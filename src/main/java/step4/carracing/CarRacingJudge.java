package step4.carracing;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingJudge {
  public static List<Car> judgeWinners(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    return filterWinners(cars, maxPosition);
  }

  private static List<Car> filterWinners(List<Car> cars, int maxPosition) {
    return cars.stream().filter(car -> car.isSame(maxPosition)).collect(Collectors.toList());
  }

  private static int getMaxPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = car.getMax(maxPosition);
    }
    return maxPosition;
  }
}
