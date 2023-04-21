package racingcar.application;

import java.util.stream.IntStream;
import racingcar.dto.CarName;

public class Car {
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

  // TODO: view로 보내야 함
  private String calculateProgress() {
    StringBuilder stringBuilder = new StringBuilder();
    IntStream.rangeClosed(1, location)
        .forEach(num -> stringBuilder.append("-"));

    return stringBuilder.toString();
  }
}
