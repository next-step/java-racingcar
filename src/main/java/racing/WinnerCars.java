package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class WinnerCars {

  List<Car> cars = new ArrayList<>();

  void add(Car car) {

    if (cars.isEmpty()) {
      cars.add(car);
      return;
    }

    if (car.isLoser(cars.get(0))) {
      return;
    }

    if (car.isWinner(cars.get(0))) {
      cars = new ArrayList<>();
    }

    cars.add(car);
  }

  String getWinnerNames() {

    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
  }
}
