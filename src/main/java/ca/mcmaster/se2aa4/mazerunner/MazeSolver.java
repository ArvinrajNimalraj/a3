package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeSolver {
  private static final Logger logger = LogManager.getLogger(MazeSolver.class);

  public Path solve(Maze maze) {
    Path path = new Path();
    Position currentPos = maze.getStart();
    Direction dir = determineInitialDirection(maze, currentPos);

    while (!currentPos.equals(maze.getEnd())) {
      if (!maze.isWall(currentPos.move(dir.turnRight()))) {
        dir = dir.turnRight();
        path.addStep('R');
        currentPos = currentPos.move(dir);
        path.addStep('F');
      } else if (!maze.isWall(currentPos.move(dir))) {
        currentPos = currentPos.move(dir);
        path.addStep('F');
      } else if (!maze.isWall(currentPos.move(dir.turnLeft()))) {
        dir = dir.turnLeft();
        path.addStep('L');
        currentPos = currentPos.move(dir);
        path.addStep('F');
      } else {
        dir = dir.turnRight().turnRight();
        path.addStep('R');
        path.addStep('R');

        if (!maze.isWall(currentPos.move(dir))) {
        currentPos = currentPos.move(dir);
      } else {
          logger.error("Backtracking failed, no valid moves.");
          break;
        }
      }
      logger.debug("Current Position: " + currentPos + " | Current Path: " + path.getCanonicalForm());
    } 
    return path;
  }
  
    private Direction determineInitialDirection(Maze maze, Position start) {
      if (start.getX() == 0) return Direction.RIGHT;
      if (start.getY() == 0) return Direction.DOWN;
      if (start.getX() == maze.getSizeX() - 1) return Direction.LEFT;
      if (start.getY() == maze.getSizeY() - 1) return Direction.UP;
      return Direction.RIGHT;
    }
  
}
