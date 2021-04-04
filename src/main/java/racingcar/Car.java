package racingcar;

import java.util.Random;

public class Car {

  private int position;
  private final MovingStrategy movingStrategy;

  public Car(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
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
}
