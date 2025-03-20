package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingJudge {
  public static List<Car> judgeWinners(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    return getWinners(cars, maxPosition);
  }

  private static List<Car> getWinners(List<Car> cars, int maxPosition) {
    return cars.stream().filter(car -> isCarValidWinner(maxPosition, car)).collect(Collectors.toList());
  }

  private static boolean isCarValidWinner(int maxPosition, Car car) {
    return car.getPosition() == maxPosition;
  }

  private static int getMaxPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }
    return maxPosition;
  }
}
