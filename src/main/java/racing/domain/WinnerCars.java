package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

  private List<Car> cars = new ArrayList<>();

  void add(Car addCar) {

    if (isWinnerCar(addCar)) {
      removeLoserCars(addCar);
      cars.add(addCar);
    }
  }

  private void removeLoserCars(Car addCar) {

    cars = cars.stream()
        .filter(car -> car.isWinner(addCar))
        .collect(Collectors.toList());
  }

  private boolean isWinnerCar(Car addCar) {
    if (cars.isEmpty()) {
      return true;
    }

    return cars.stream().allMatch(addCar::isWinner);
  }

  public String getWinnerNames() {

    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
  }
}
