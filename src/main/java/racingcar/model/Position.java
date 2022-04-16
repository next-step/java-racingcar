package racingcar.model;

import java.util.Objects;

public class Position {

  private final int value;

  public Position(int value) {
    validatePosition(value);
    this.value = value;
  }

  public Position increment() {
    return new Position(value + 1);
  }

  public int getPosition() {
    return value;
  }

  private static void validatePosition(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
    }
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
