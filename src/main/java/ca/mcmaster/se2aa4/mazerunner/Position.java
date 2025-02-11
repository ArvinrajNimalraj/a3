package ca.mcmaster.se2aa4.mazerunner;

public class Position {
  private final int x, y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position move(Direction dir) {
    return new Position(x + dir.getDx(), y + dir.getDy());
  }

  public int getX() { return x; }
  public int getY() { return y; }

  public boolean equals(object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Position position = (Position) obj;
    return x == position.x && y == position.y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}
