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

  public String getName() {
    return name.toString();
  }

  public void move() {
    if (carMoveStrategy.shouldMove()) {
      position.increase(MOVE_STEP);
    }
  }

  public boolean isSamePosition(int value) {
    return position.isSame(value);
  }

  public int compareMaxPosition(int compareValue) {
    return position.compareMax(compareValue);
  }

  @Override
  public String toString() {
    return name.getValue() + " : " + position.getStatus();
  }
}
