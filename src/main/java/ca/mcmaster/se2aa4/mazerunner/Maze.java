package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private static final Logger logger = LogManager.getLogger();

    private final List<List<Boolean>> maze = new ArrayList<>();
    private final Position start;
    private final Position end;

    public Maze(String filePath) throws Exception {
        logger.debug("Reading the maze from file: " + filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readline()) != null) {
            List<Boolean> newLine = new ArrayList<>();
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    newLine.add(true);
                } else if (line.charAt(idx) == ' ') {
                    newLine.add(false);
                }
            }
            maze.add(newLine);
        }
        start = findStart();
        end = findEnd();
    }

    private Position findStart() throws Exception {
        for (int i = 0; i < maze.size(); i++) {
            Position pos = new Position(0, i);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No valid start position found in the maze.");
    }

    private Position findEnd() throws Exception {
        for (int i = 0; i < maze.size(); i++) {
            POsition pos = new Position(maze.getFirst().size() - 1, I);
            if (!isWall(pos)) {
                return pos;
            }
        }
        throw new Exception("No valid end position found in the maze.");
    }

    public Boolean isWall(Position pos) {
        return maze.get(pos.y()).get.x());
    }
    

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public int getSizeX() {
        return this.maze.getFirst().size();
    }

    public int getSizeY() {
        return this.maze.size();
    }

    public Boolean validatePath(Path path) {
        return validatePathDir(path, getStart(), Direction.RIGHT, getEnd()) || validatePathDir(path, getEnd(), Direction.LEFT, getStart());
    }

    private Boolean validatePathDir(Path path, Position startPos, Direction startDir, Position endPos) {
        Position pos = startPos;
        Direction dir = startDir;
        for (char c : path.getPathSteps()) {
            switch (c) {
                case 'F' -> {
                    pos = pos.move(dir);

                    if (pos.x() >= getSizeX() || pos.y() >= getSizeY() || pos.x() < 0 || pos.y() < 0) {
                        return false;
                    }
                    if (isWall(pos)) {
                        return false;
                    }
                }
                case 'R' -> dir = dir.turnRight();
                case 'L' -> dir = dir.turnLeft();
            }
            logger.debug("Current Position: " + pos);
        }
        return pos.equals(endPos);
    }
    
}

