package study.racingcar.domain;

import java.util.Objects;

public class Position {

  private static final int DEFAULT_START_NUMBER = 0;

  private int number;

  public Position() {
    number = DEFAULT_START_NUMBER;
  }

  public Position(final int number) {
    if (number < DEFAULT_START_NUMBER) {
      throw new IllegalArgumentException("위치 값은 0 이상이어야 합니다.");
    }
    this.number = number;
  }

  public void increase() {
    this.number++;
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
    return number == position.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  public Position getMaxPosition(Position otherPosition) {
    if (this.number > otherPosition.number) {
      return this;
    }
    return otherPosition;
  }

  public String getFootPrint(String footPrint) {
    return footPrint.repeat(this.number);
  }
}
