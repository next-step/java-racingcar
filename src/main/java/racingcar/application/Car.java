package racingcar.application;

public class Car {
  private static final int GO_BOUNDARY = 3;

  private int location = 1;

  public void go(MoveStrategy moveStrategy) {
    location += moveStrategy.move();
  }

  public int location() {
    return this.location;
  }
}
