package study.racinggame.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> unmodifiableCars() {
    return Collections.unmodifiableList(cars);
  }
}
