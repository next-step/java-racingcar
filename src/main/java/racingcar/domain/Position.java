package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

  private static final int DEFAULT_POSITION = 0;
  private int value;

  public Position() {
    this(DEFAULT_POSITION);
  }

  public Position(int value) {
    this.value = value;
  }

  public void increase() {
    value++;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return value == position.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public int compareTo(Position other) {
    return Integer.compare(value, other.value);
  }
}
