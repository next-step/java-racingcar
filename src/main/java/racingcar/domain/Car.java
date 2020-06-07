package racingcar.domain;

import racingcar.util.MovingStrategy;

public class Car {

  private int position;
  private String name;

  private Car(String name) {
    this.position = 0;
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }

  public int updatePosition(MovingStrategy strategy) {
    if (strategy.isMove()) {
      this.position = this.position + 1;
    }
    return this.position;
  }

  public static Car create(String name) {
    return new Car(name);
  }
}
