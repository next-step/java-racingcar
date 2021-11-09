package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car {
  private int position;

  public int getCurrentPosition() {
    return position;
  }

  public void move(MovingStrategy movingStrategy) {
    if (movingStrategy.isMovable()) {
      this.position++;
    }
  }

}
