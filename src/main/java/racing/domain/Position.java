package racing.domain;

import java.util.Objects;

public class Position {

  private final int position;

  private Position(int position) {
    if (position < 0)
      throw new IllegalArgumentException("position is not positive number");
    this.position = position;
  }

  public static Position Zero() {
    return new Position(0);
  }

  public static Position create(int position) {
    return new Position(position);
  }

  public Position move() {
    return create(position + 1);
  }

  public boolean isWinner(Position winnerPosition) {
    return this.equals(winnerPosition);
  }

  public int compareTo(Position other) {
    return Integer.compare(position, other.position);
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
    return String.valueOf(position);
  }
}
