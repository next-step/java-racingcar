package racingCar.model;

import java.util.Objects;
import racingCar.strategy.CarMoveStrategy;

public class Car {

  private final CarName carName;
  private final Position position;

  public Car(String name) {
    this(new CarName(name).toString(), 0);
  }

  public Car(String name, int position) {
    this.carName = new CarName(name);
    this.position = new Position(position);
  }

  public Car move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return new Car(this.carName.toString(), this.position.increase());
    }
    return this;
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
    return position.x == car.position.x && Objects.equals(carName.toString(),
        car.carName.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName.toString(), position.x);
  }

  public Position position() {
    return this.position;
  }


  @Override
  public String toString() {
    return carName.toString();
  }
}
