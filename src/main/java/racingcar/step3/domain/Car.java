package racingcar.step3.domain;

import racingcar.step3.domain.strategy.CarMoveStrategy;

import java.util.UUID;

public class Car {

  public static final int DEFAULT_START_POSITION = 0;

  private final UUID id = UUID.randomUUID();
  private final String carName;
  private int position;
  private final CarMoveStrategy moveStrategy;

  public Car(String carName, CarMoveStrategy carMoveStrategy) {
    this.carName = carName;
    this.position = DEFAULT_START_POSITION;
    this.moveStrategy = carMoveStrategy;
  }

  public String getCarName() {
    return carName;
  }

  public int getPosition() {
    return position;
  }

  public void moveTo(int position) {
    this.position = position;
  }

  public void move() {
    if (this.moveStrategy.isMovable()) {
      this.position += 1;
    }
  }
}
