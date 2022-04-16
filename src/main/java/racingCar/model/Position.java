package racingCar.model;

import java.util.Objects;

public class Position {
  private static final String STEP = "-";
  protected int x;

  protected Position(int x) {
    this.x = x;
  }

  public int increase() {
    return this.x = x + 1;
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
