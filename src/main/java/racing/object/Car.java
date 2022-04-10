package racing.object;

import racing.strategy.MoveStrategy;

public class Car {

  private int distance;
  private MoveStrategy moveStrategy;

  public Car() {
  }

  public Car(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void attempt() {
    if (moveStrategy.canMove()) {
      move();
    }
  }

  public void move() {
    addDistance();
  }

  public int getDistance() {
    return distance;
  }

  public void setMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  private void addDistance() {
    this.distance++;
  }

}
