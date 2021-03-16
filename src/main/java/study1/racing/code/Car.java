package study1.racing.code;

import study1.racing.code.moveStrategy.MoveStrategy;
import study1.racing.code.moveStrategy.RaceMove;

public class Car {

  private MoveStrategy moveStrategy;

  private int distance = 0;

  public int getDistance() {
    return distance;
  }

  public Car() {
    this.moveStrategy = new RaceMove();
  }

  public Car(int initDistance) {
    this.distance = initDistance;
  }

  public Car(Car c) {
    this.distance = c.distance;
    this.moveStrategy = c.moveStrategy;
  }

  public int move(MoveStrategy moveStrategy) {
    distance += moveStrategy.move() ? 1 : 0;
    return distance;
  }
}
