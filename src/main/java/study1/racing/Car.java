package study1.racing;

import study1.racing.moveStrategy.MoveStrategy;
import study1.racing.moveStrategy.RaceMove;

public class Car {

  private final int MAX_DISTANCE = 1;

  private MoveStrategy moveStrategy;

  private int distance = 0;

  public void setMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public Car() {
    this.moveStrategy = new RaceMove();
  }

  public int move() {
    distance += moveStrategy.move(MAX_DISTANCE);
    return distance;
  }
}
