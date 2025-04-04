package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path path = new Path();
        Position currentPos = maze.getStart();
        Direction dir = Direction.RIGHT;

        // Initialize commands
        Command turnRightCommand = new TurnRightCommand();
        Command moveForwardCommand = new MoveForwardCommand();
        Command turnLeftCommand = new TurnLeftCommand();
        Command turnAroundCommand = new TurnAroundCommand();

        while (!currentPos.equals(maze.getEnd())) {
            if (!maze.isWall(currentPos.move(dir.turnRight()))) {
                turnRightCommand.execute(currentPos, dir, path, maze);
            } else if (!maze.isWall(currentPos.move(dir))) {
                moveForwardCommand.execute(currentPos, dir, path, maze);
            } else if (!maze.isWall(currentPos.move(dir.turnLeft()))) {
                turnLeftCommand.execute(currentPos, dir, path, maze);
            } else {
                turnAroundCommand.execute(currentPos, dir, path, maze);
            }
            logger.debug("Current Position: " + currentPos + "\nCurrent Path: " + path.getCanonicalForm());
        }

        return path;
    }
}

/*
package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Path solve(Maze maze) {
        Path path = new Path();

        Position currentPos = maze.getStart();
        Direction dir = Direction.RIGHT;
        while (!currentPos.equals(maze.getEnd())) {
            if (!maze.isWall(currentPos.move(dir.turnRight()))) {
                // Turn right and move forward if not a wall
                dir = dir.turnRight();
                path.addStep('R');
                currentPos = currentPos.move(dir);
                path.addStep('F');
            } else {
                if (!maze.isWall(currentPos.move(dir))) {
                    // Go forward if not a wall
                    currentPos = currentPos.move(dir);
                    path.addStep('F');
                } else if (!maze.isWall(currentPos.move(dir.turnLeft()))) {
                    // Go left if not a wall
                    dir = dir.turnLeft();
                    path.addStep('L');
                    currentPos = currentPos.move(dir);
                    path.addStep('F');
                } else {
                    // Turn around
                    dir = dir.turnRight().turnRight();
                    path.addStep('R');
                    path.addStep('R');
                }
            }
            logger.debug("Current Position: " + currentPos.toString() + "\n Current Path: " + path.getCanonicalForm());
        }

        return path;
    }
}
*/
