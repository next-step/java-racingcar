package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

  public static Winners announceWinners(Cars car) {
    List<Car> cars = car.getCars();
    int maxPosition = getMaxPosition(cars);
    return winners(maxPosition, cars);
  }

  private static int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .max(Comparator.comparingInt(Car::getPosition))
        .get()
        .getPosition();
  }

  private static Winners winners(int maxPosition, List<Car> cars) {
    return new Winners(cars.stream()
        .filter(car -> car.isMyPosition(maxPosition))
        .collect(Collectors.toList()));
  }

}
