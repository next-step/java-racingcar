package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {

  private int carPosition = 0;
  private String name;

  public Car(String name) {
    this.name = name;
    this.carPosition = 0;
  }

  public void move(MovingStrategy movingStrategy) {
    if (movingStrategy.isMoveAble()) {
      carPosition++;
    }
  }

  public String getName() {
    return name;
  }

  public int getCarPosition() {
    return carPosition;
  }

  public ScoreBoard scoreBoard() {
    return new ScoreBoard(this.name, this.carPosition);
  }
}
