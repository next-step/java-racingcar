package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
  private List<Car> cars;

  public Cars() {
    cars = new ArrayList<>();
  }

  public void forwardCars(List<Car> cars) {
    for (Car car : cars) {
      car.forward(new RacingGameStrategy());
    }
  }
}
