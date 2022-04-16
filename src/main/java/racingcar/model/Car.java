package racingcar.model;

import java.util.Objects;

public class Car {

  private Position position;

  private Name name;

  public Car(int position, String name) {
    this.position = new Position(position);
    this.name = new Name(name);
  }

  public Position getPosition() {
    return position;
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
