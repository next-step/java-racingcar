package study.step3.domain;

import java.util.List;

public class Race {

  private List<Car> carList;

  public Race(List<Car> carList) {
    this.carList = carList;
  }

  public void play() {
    for (Car car : carList) {
      car.randomMove();
    }
  }

  public List<Car> getCarList() {
    return carList;
  }
}
