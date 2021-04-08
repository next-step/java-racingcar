package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.CarStatusDTO;
import racingcar.car.strategy.MovingStrategy;
import racingcar.exception.TryMovingCarException;

public class Racing {

  private final List<Car> cars;
  private int remainTryCount;

  public Racing(RacingRule racingRule, MovingStrategy movingStrategy) {
    this.cars = racingRule.getCarNameList()
        .stream()
        .map(carName -> new Car(movingStrategy, carName))
        .collect(Collectors.toList());
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

  public List<CarStatusDTO> currentSituation() {
    return this.cars.stream()
        .map(CarStatusDTO::new)
        .collect(Collectors.toList());
  }

  public List<String> getWinnerCarName() {
    int maxPosition = this.cars.stream()
        .map(Car::getPosition)
        .max(Integer::compare)
        .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어 있습니다."));
    return this.cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }
}
