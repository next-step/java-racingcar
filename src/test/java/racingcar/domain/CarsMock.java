package racingcar.domain;

import java.util.List;

public class CarsMock extends Cars {

  private CarsMock(List<Car> cars) {
    super(cars);
  }

  public static CarsMock create(List<Car> cars) {
    return new CarsMock(cars);
  }
}
