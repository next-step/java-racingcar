package racingcar.application;

import java.util.stream.IntStream;
import racingcar.dto.CarName;
import racingcar.dto.CarNames;

public class Car {
  private int location = 1;
  private final CarName name;

  public Car(CarName name) {
    this.name = name;
  }

  public void go(MoveStrategy moveStrategy) {
    location += moveStrategy.move();
  }

  public String location() {
    return this.name.toString() + " : " + progress();
  }

  private String progress() {
    StringBuilder stringBuilder = new StringBuilder();
    IntStream.rangeClosed(1, location)
        .forEach(num -> stringBuilder.append("-"));

    return stringBuilder.toString();
  }
}
