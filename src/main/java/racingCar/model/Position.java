package racingCar.model;

import java.util.Objects;

public final class Position {

  private static final String STEP = "-";
  private static final int INCREASE_MOVE_VALUE = 1;
  private final int x;


  public Position(int x) {
    valid(x);
    this.x = x;
  }

  public Position increase() {
    return new Position(this.x + INCREASE_MOVE_VALUE);
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
    return Objects.equals(x, position.x);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x);
  }


  public void valid(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("포지션은 음수 값을 넣을 수 없습니다.");
    }
  }
  @Override
  public String toString() {
    return STEP.repeat(x);
  }

}
