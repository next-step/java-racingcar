package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.TryMovingCarException;

public class Racing {

  private final List<Car> cars;
  private int remainTryCount;

  public Racing(RacingRule racingRule, MovingStrategy movingStrategy) {
    this.cars = new ArrayList<>();
    int carCount = racingRule.getCarCount();
    for (int i = 0; i < carCount; ++i) {
      cars.add(new Car(movingStrategy));
    }
    this.remainTryCount = racingRule.getTryCount();
  }

  public boolean canTry() {
    return this.remainTryCount > 0;
  }

  public void tryMoveCars() throws TryMovingCarException {
    if (!canTry()) {
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

  public List<Integer> currentSituation() {
    return this.cars.stream()
        .map(Car::getPosition)
        .collect(Collectors.toList());
  }
}
