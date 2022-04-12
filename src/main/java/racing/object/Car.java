package racing.object;

import racing.strategy.MoveStrategy;

public class Car {

  private int distance;
  private final MoveStrategy moveStrategy;

  public Car(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void attempt() {
    if (moveStrategy.canMove()) {
      move();
    }
  }

  public void move() {
    this.distance++;
  }

  public int getDistance() {
    return distance;
  }

}
