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

  public void move(int times) {
    for (int i = 0; i < times; i++) {
      this.cars.forEach(car -> car.move(RandomNumber.generator()));
    }
  }

}
