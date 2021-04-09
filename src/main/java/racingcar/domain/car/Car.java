package racingcar.domain.car;

import racingcar.domain.car.strategy.MovingStrategy;

public class Car {

  private int position;
  private final MovingStrategy movingStrategy;
  private final String carName;

  public Car(MovingStrategy movingStrategy, String carName) {
    this.movingStrategy = movingStrategy;
    this.carName = carName;
  }

  public void tryMove() {
    if (this.movingStrategy.isCanMove()) {
      moveOne();
    }
  }

  private void moveOne() {
    this.position++;
  }

  public int getPosition() {
    return this.position;
  }

  public String getCarName() {
    return carName;
  }
}
