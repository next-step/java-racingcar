package step4.carracing.domain;

import step4.carracing.CarMoveStrategy;

public class Car {
  private static final int INIT_POSITION = 0;
  private static final int MOVE_STEP = 1;

  private final Position position;
  private final CarName name;
  private final CarMoveStrategy carMoveStrategy;

  public Car(int position, String name, CarMoveStrategy carMoveStrategy) {
    this.position = new Position(position);
    this.name = new CarName(name);
    this.carMoveStrategy = carMoveStrategy;
  }

  public Car(String name, CarMoveStrategy carMoveStrategy) {
    this(INIT_POSITION, name, carMoveStrategy);
  }

  public void move() {
    if (carMoveStrategy.shouldMove()) {
      position.increase(MOVE_STEP);
    }
  }

  public String getName() {
    return name.getValue();
  }

  public boolean isSame(int value) {
    return position.isSame(value);
  }

  public int getMax(int compareValue) {
    return position.getMax(compareValue);
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    Car car = (Car) o;
//    return Objects.equals(name, car.name);
//  }

  @Override
  public String toString() {
    return name.getValue() + " : " + position.getStatus();
  }
}
