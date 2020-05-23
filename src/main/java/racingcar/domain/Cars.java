package racingcar.domain;

import java.util.List;

public class Cars {

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  private final List<Car> cars;

  public List<Car> getCars() {
    return cars;
  }

  public static Cars create(List<Car> cars) {
    return new Cars(cars);
  }
}
