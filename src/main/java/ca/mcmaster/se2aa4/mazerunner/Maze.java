package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private static final Logger logger = LogManager.getLogger(Maze.class);

    private final List<List<Boolean>> maze = new ArrayList<>();
    private final Position start;
    private final Position end;

    public Maze(String filePath) throws IOException {
        logger.info("Reading the maze from file: " + filePath);
        
        loadMaze(filePath);
        validateMaze();
        this.start = findStart();
        this.end = findEnd();
    }

    private Position findStart() {
        for (int y = 0; y < maze.size(); y++) {
            Position pos = new Position(0, y);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new IllegalArgumentException("No valid start position found in the maze.");
    }

    private Position findEnd() {
        int lastColumn = maze.get(0).size() - 1;
        for (int y = 0; y < maze.size(); y++) {
            Position pos = new Position(lastColumn, y);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("Invalid maze (no end position available)");
    }

    public boolean isWall(Position pos) {
        if (maze.isEmpty() || pos.getY() < 0 || pos.getY() >= maze.size() || pos.getX() < 0 || pos.getX() >= maze.get(0).size()) {
            return true;
        }
        return maze.get(pos.getY()).get(pos.getX());
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public int getSizeX() {
        return this.maze.get(0).size();
    }

    public int getSizeY() {
        return this.maze.size();
    }
}

