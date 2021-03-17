package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

  public static List<Car> determineWinners(List<Car> cars) {
    int max = getMaxPosition(cars);

    return cars.stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
  }

  private static int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(-1);
  }

}
