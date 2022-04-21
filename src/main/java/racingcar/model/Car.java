package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car implements Comparable<Car> {

  private final MovingStrategy movingStrategy;
  private final CarName carName;
  private final Position position;

  public Car(MovingStrategy movingStrategy, String name) {
    this(movingStrategy, CarName.create(name));
  }

  Car(MovingStrategy movingStrategy, CarName carName) {
    this(movingStrategy, carName, Position.create());
  }

  Car(MovingStrategy movingStrategy, CarName carName, Position position) {
    this.movingStrategy = movingStrategy;
    this.carName = carName;
    this.position = position;
  }

  public static Car create(MovingStrategy movingStrategy, String name) {
    return new Car(movingStrategy, name);
  }

  public void move() {
    if (movingStrategy.decideWhetherToMove()) {
      position.increaseValue();
    }
  }

  public int getCurrentPosition() {
    return position.getValue();
  }

  public String getCarName() {
    return carName.getValue();
  }

  public boolean compareWithMaxPosition(Car maxPositionCar) {
    return this.position.equals(maxPositionCar.position);
  }

  @Override
  public int compareTo(Car otherCar) {
    return this.position.compareTo(otherCar.position);
  }
}
