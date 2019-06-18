package racinggame.model;

import racinggame.util.RandomValueUtil;

public class Car {

  private static final int DEFAULT_STATUS = 1;
  private static final int MOVE_VALUE = 4;

  private int status;

  public Car() {
    this.status = DEFAULT_STATUS;
  }

  public void move() {
    status++;
  }

  public int getStatus() {
    return status;
  }

  public boolean isMove() {
    return RandomValueUtil.getRandomValue() >= MOVE_VALUE;
  }
}
