package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

  public static String announceWinners(Cars car) {
    List<Car> cars = car.getCars();
    int maxPosition = getMaxPosition(cars);
    List<Car> winner = getWinner(maxPosition, cars);
    return getWinnerName(winner);
  }

  private static List<Car> getWinner(int maxPosition, List<Car> cars) {
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .collect(Collectors.toList());
  }

  private static int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .max(Comparator.comparingInt(Car::getPosition))
        .get()
        .getPosition();
  }

  private static String getWinnerName(List<Car> winner) {
    return winner.stream().map(Car::getName)
        .collect(Collectors.joining(","));
  }

}
