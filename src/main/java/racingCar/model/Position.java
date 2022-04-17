package racingCar.model;

import java.util.Objects;

public class Position {

  private static final String STEP = "-";
  private final int x;

  public Position(int x) {
    valid(x);
    this.x = x;
  }


  public static Position increase(Position origin, Position addPosition) {
    return new Position(origin.x + addPosition.x);
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


  public boolean match(Position other) {
    return this.x < other.x;
  }

  public void valid(int x) {
    if(x < 0) {
      throw new IllegalArgumentException("포지션은 음수 값을 넣을 수 없습니다.");
    }
  }
  @Override
  public String toString() {
    return STEP.repeat(x);
  }
}
