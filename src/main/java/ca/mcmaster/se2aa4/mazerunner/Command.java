package ca.mcmaster.se2aa4.mazerunner;

public interface Command {
    void execute(Position currentPosition, Direction direction, Path path, Maze maze);
}

public class TurnRightCommand implements Command {
    @Override
    public void execute(Position currentPosition, Direction direction, Path path, Maze maze) {
        if (!maze.isWall(currentPosition.move(direction.turnRight()))) {
            direction = direction.turnRight();
            path.addStep('R');
            currentPosition = currentPosition.move(direction);
            path.addStep('F');
        }
    }
}

public class TurnLeftCommand implements Command {
    @Override
    public void execute(Position currentPosition, Direction direction, Path path, Maze maze) {
        if (!maze.isWall(currentPosition.move(direction.turnLeft()))) {
            direction = direction.turnLeft();
            path.addStep('L');
            currentPosition = currentPosition.move(direction);
            path.addStep('F');
        }
    }
}

public class TurnAroundCommand implements Command {
    @Override
    public void execute(Position currentPosition, Direction direction, Path path, Maze maze) {
        direction = direction.turnRight().turnRight();
        path.addStep('R');
        path.addStep('R');
    }
}
