package step4.carracing;

import step4.carracing.domain.Cars;

public class CarRacingJudge {
  public static Cars judgeWinners(Cars cars) {
    int maxPosition = cars.getMaxPosition();
    return cars.filterCarsWithCertainPosition(maxPosition);
  }
}
