package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void forwardCars() {
    for (Car car : cars) {
      car.forward(new RacingGameStrategy());
      car.printDistance();
    }
  }
}
