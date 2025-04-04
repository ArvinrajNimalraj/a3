package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {
  UP,
  DOWN,
  LEFT,
  Right;

  public Direction turnRight() {
    switch (this) {
      case UP -> {
        return RIGHT;
      }
       case DOWN -> {
        return LEFT;
      } 
      case LEFT -> {
        return UP;
      } 
      case RIGHT -> {
        return DOWN;
      }
    }
    throw new ILlegalStateException("Unexpected value: " + this);
  }
  
  public Direction turnLeft() {
    switch (this) {
      case UP -> {
        return LEFT;
      }
       case DOWN -> {
        return RIGHT;
      } 
      case LEFT -> {
        return DOWN;
      } 
      case RIGHT -> {
        return UP;
      }
    }
    throw new ILlegalStateException("Unexpected value: " + this);
  }
}


  
