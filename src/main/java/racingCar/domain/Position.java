package racingCar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
  private static final int MIN_MOVE_NUMBER = 5;

  private final int value;

  public Position(int startPosition) {
    this.value = startPosition;
  }

  public Position move(MyNumber number) {
    if (canMove(number)) {
      return new Position(value + 1);
    }
    return this;
  }

  private boolean canMove(MyNumber number) {
    return number.getNumber() >= MIN_MOVE_NUMBER;
  }

  public int getValue() {
    return value;
  }

  @Override
  public int compareTo(Position other) {
    return Integer.compare(value, other.value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position other = (Position) o;
    return value == other.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
