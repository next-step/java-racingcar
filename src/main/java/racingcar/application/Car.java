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

  public String progress() {
    return this.name.toString() + " : " + calculateProgress();
  }

  public int location() {
    return location;
  }

  public String carName() {
    return name.toString();
  }

  private String calculateProgress() {
    StringBuilder stringBuilder = new StringBuilder();
    IntStream.rangeClosed(1, location)
        .forEach(num -> stringBuilder.append("-"));

    return stringBuilder.toString();
  }
}
