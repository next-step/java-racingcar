package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
  public static List<Car> findWinner(List<Car> cars) {
    return findWinners(cars, maxPosition(cars));
  }

  private static List<Car> findWinners(List<Car> cars, int maxPosition) {
    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      if (maxPosition == car.getPosition()) {
        winners.add(car);
      }
    }
    return winners;
  }

  private static int maxPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      if (maxPosition < car.getPosition()) {
        maxPosition = car.getPosition();
      }
    }
    return maxPosition;
  }
}
