package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
  UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

  private final int dx, dy;

  Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  public Direction turnRight() {
    return switch (this) {
      case UP -> RIGHT;
      case RIGHT -> DOWN;
      case DOWN -> LEFT;
      case LEFT -> UP;
    }
  }
  
    public Direction turnLeft() {
    return switch (this) {
      case UP -> LEFT;
      case LEFT -> DOWN;
      case DOWN -> RIGHT;
      case RIGHT -> UP;
    }
  }

  public int getDx() { return dx; }
  public int getDy() { return dy; }

}


  
