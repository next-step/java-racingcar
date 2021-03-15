package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

  public List<Car> determineWinners(List<Car> cars) {
    int max = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(-1);

    return cars.stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
  }

}
