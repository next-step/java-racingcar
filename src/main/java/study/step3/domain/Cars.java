package study.step3.domain;

import java.util.List;
import java.util.stream.Collectors;

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

  public String findWinners(int times) {
    return cars.stream()
        .filter(car -> car.curPosition() == times)
        .map(Car::name)
        .collect(Collectors.joining(","));
  }

}
