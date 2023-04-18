package racingcar.application;

public class Car {
  private int location = 1;
  private final String name;

  public Car(String name) {
    this.name = name;
  }

  public void go(MoveStrategy moveStrategy) {
    location += moveStrategy.move();
  }

  public int location() {
    return this.location;
  }
}
