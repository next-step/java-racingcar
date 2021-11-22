package racingCar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {
  private static final int MIN_MOVE_NUMBER = 5;

  private final int value;

  public Position(int inputNumber) {
    this.value = inputNumber;
  }

  public Position move(int inputNumber) {
    if (canMove(inputNumber)) {
      return new Position(value + 1);
    }
    return this;
  }

  private boolean canMove(int position) {
    return position >= MIN_MOVE_NUMBER;
  }

  public int getValue() {
    return value;
  }

  @Override
  public int compareTo(Position other) {
    return value - other.value;
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
