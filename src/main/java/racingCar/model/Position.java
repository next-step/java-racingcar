package racingCar.model;

import java.util.Objects;

public class Position {

  private static final String STEP = "-";
  private int x;

  public Position(int x) {
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

  @Override
  public String toString() {
    return STEP.repeat(x);
  }
}
