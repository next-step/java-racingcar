package racingcar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {

  private static final int POSITION_INITIAL_VALUE = 0;
  private int value;

  public Position() {
    this(POSITION_INITIAL_VALUE);
  }

  Position(int position) {
    this.value = position;
  }

  public static Position create() {
    return new Position();
  }

  public void increaseValue() {
    value = value + 1;
  }

  public int getValue() {
    return value;
  }

  @Override
  public int compareTo(Position otherPosition) {
    return Integer.compare(value, otherPosition.value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return value == position.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
