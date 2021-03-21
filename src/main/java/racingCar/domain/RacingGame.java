package racingCar.domain;

import java.util.List;
import racingCar.domain.Cars;
import racingCar.domain.TryCount;
import racingCar.domain.TryResult;
import racingCar.view.TryResultsView;

public class RacingGame {

  private final TryCount tryCount;
  private final Cars cars;

  public RacingGame(String[] carNames, int tryCount) {
    this.cars = new Cars(carNames);
    this.tryCount = new TryCount(tryCount);
  }

  public TryResultsView race() {
    List<TryResult> tryResults = cars.move();
    tryCount.race();
    return new TryResultsView(tryResults);
  }

  public boolean isRacing() {
    return tryCount.isMoreZero();
  }

  public Cars getCars() {
    return cars;
  }
}
