package racingCar.model;

import java.util.Objects;
import racingCar.strategy.CarMoveStrategy;

public class Car {

  private final CarName carName;
  private final Position position;

  public Car(String name) {
    this(new CarName(name).toString(), new Position(0));
  }

  public Car(String name, Position position) {
    this.carName = new CarName(name);
    this.position = position;
  }

  public Car move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return new Car(this.carName.toString(), Position.increase(position, new Position(1)));
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
    return position == car.position && Objects.equals(carName.toString(),
        car.carName.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName.toString(), position);
  }


  @Override
  public String toString() {
    return String.format("%s : %s", carName.toString(), position.toString());
  }
}
