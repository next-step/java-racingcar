package racingcar.model;

import java.util.Objects;

public class Car {

  private Position position;

  public Car() {
    this(0);
  }

  public Car(int position) {
    validatePosition(position);
    this.position = new Position(position);
  }

  public int getCurrentPosition() {
    return position.getPosition();
  }

  public void moveOrStop(MovingStrategy movingStrategy) {
    if (movingStrategy.movable()) {
      position = position.increment();
    }
  }

  private static void validatePosition(int position) {
    if (position < 0) {
      throw new RuntimeException("음수는 입력할 수 없습니다.");
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
    Car car = (Car) o;
    return Objects.equals(position, car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}
