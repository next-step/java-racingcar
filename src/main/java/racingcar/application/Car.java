package racingcar.application;

import java.util.stream.IntStream;
import racingcar.dto.CarName;

public class Car implements Cloneable {
  private int location = 1;
  private final CarName name;

  public Car(CarName name) {
    this.name = name;
  }

  public void go(MoveStrategy moveStrategy) {
    location += moveStrategy.move();
  }

  public int location() {
    return location;
  }

  public CarName carName() {
    return name;
  }

  @Override
  public Car clone() {
    try {
      return (Car) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }
}
