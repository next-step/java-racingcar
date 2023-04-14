package study.racingcar.domain;

import java.util.List;

public class Race {

  private List<Car> cars;

  public Race(List<Car> cars) {
    this.cars = cars;
  }

  public void play() {
    for (Car car : cars) {
      car.move();
    }
  }

  public List<Car> getCars() {
    return cars;
  }
}
