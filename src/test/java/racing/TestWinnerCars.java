package racing;

import java.util.List;

class TestWinnerCars extends WinnerCars {

  TestWinnerCars() {
    super();
  }

  TestWinnerCars(List<Car> cars) {
    this.cars = cars;
  }

  List<Car> getWinnerCars() {
    return this.cars;
  }
}
