package study1.racing.code;

import study1.racing.code.moveStrategy.MoveStrategy;
import study1.racing.code.moveStrategy.RaceMove;

public class Car {

  private final int MAX_DISTANCE = 1;

  private MoveStrategy moveStrategy;

  private int distance = 0;

  public void setMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public int getDistance() {
    return distance;
  }

  public Car() {
    this.moveStrategy = new RaceMove();
  }

  public Car(Car c) {
    this.distance = c.distance;
    this.moveStrategy = c.moveStrategy;
  }

  public int move() {
    distance += moveStrategy.move(MAX_DISTANCE);
    return distance;
  }
}
