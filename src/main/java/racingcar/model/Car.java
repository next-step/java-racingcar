package racingcar.model;

import java.util.Objects;

public class Car {

  private Position position;

  public Car(int position) {
    this.position = new Position(position);
  }

  public Car() {
    this(0);
  }

  public int getCurrentPosition() {
    return position.getPosition();
  }

  public void moveOrStop(MovingStrategy movingStrategy) {
    if (movingStrategy.movable()) {
      position = position.increment();
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
