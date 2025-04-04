package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private Static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path path = new Path();

        Position currentPos = maze.getStart();
        Direction dir = Direction.RIGHT;
        while (!currentPos.equals(maze.getEnd())) {
            if (!maze.isWall(currentPos.move(dir.turnRight()))) {
                dir = dir.turnRight();
                path.addStep('R');
                currentPos = currentPos.move(dir);
                path.addStep('F');
            } else {
                if (!maze.isWall(currentPos.move(dir))) {
                    currentPos = currentPos.move(dir);
                    path.addStep('F');
                } else if (!maze.isWall(currentPos.move(dir.turnLeft()))) {
                    dir = dir.turnLeft();
                    path.addStep('L');
                    cuurentPos = currentPos.move(dir);
                    path.addStep('F');
                } else {
                    dir = dir.turnRight().turnRight();
                    path.addStep('R');
                    path.addStep('R');
                }
            }
            logger.debug("Current Position: " currentPos.toString() + "\n Current Path: " + path.getCanonicalForm()));
        }

        return path;
    }
}


