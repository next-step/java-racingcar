package step5.model;

import step5.exception.IllegalPositionException;

import java.util.Objects;

public class Position {
  private final int position;

  public Position() {
    this(0);
  }

  public Position(int position) {
    if (position < 0) {
      throw new IllegalPositionException("적절하지 못한 위치입니다.");
    }
    this.position = position;
  }

  public Position move() {
    return move(1);
  }

  public Position move(int n) {
    return new Position(position + n);
  }

  public int getPosition() {
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

  @Override
  public String toString() {
    return "Position{" +
      "position=" + position +
      '}';
  }

  public boolean isBigger(Position maxPosition) {
    return this.position > maxPosition.position;
  }
}
