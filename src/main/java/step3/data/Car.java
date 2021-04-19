package step3.data;

import step3.strategy.MoveStrategy;

public class Car {

  private Integer position;

  public Car() {
    this.position = 0;
  }

  public Integer getPosition() {
    return this.position;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMove()) {
      this.position++;
    }
  }

}
