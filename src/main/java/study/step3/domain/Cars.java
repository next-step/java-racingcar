package study.step3.domain;

import java.util.List;
import study.step3.validator.RandomNumber;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return this.cars;
  }

  public void move() {
    this.cars.forEach(Car::move);
  }

}
