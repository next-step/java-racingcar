package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.TryMovingCarException;

public class Racing {

  private final List<Car> cars;
  private int remainTryCount;

  public Racing(RacingRule racingRule) {
    this.cars = new ArrayList<>();
    int carCount = racingRule.getCarCount();
    for (int i = 0; i < carCount; ++i) {
      cars.add(new Car());
    }
    this.remainTryCount = racingRule.getTryCount();
  }

  public void tryMoveCars() throws TryMovingCarException {
    if (this.remainTryCount <= 0) {
      throw new TryMovingCarException();
    }
    this.cars
        .forEach(
            Car::tryMove
        );
    this.remainTryCount--;
  }

  public int getRemainTryCount() {
    return this.remainTryCount;
  }

  public String currentSituation() {
    String remainString = "REMAIN TRY COUNT : " + this.remainTryCount;
    StringBuilder builder = new StringBuilder();
    builder.append(remainString);
    for (Car car : this.cars) {
      builder.append(car.getPositionString());
      builder.append("\n");
    }
    return builder.toString();
  }
}
