package step3;

import step3.domain.Car;
import step3.domain.Cars;
import step3.service.RandomRacingRule;
import step3.view.RacingGameOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

  private static final String SPLIT_FLAG = ",";
  private static final int RANDOM_BOUND = 10;

  private final Cars cars;
  private final int gameCount;

  public RacingGame(String carNames, int gameCount) {
    this.cars = new Cars(initCars(carNames));
    this.gameCount = gameCount;
  }

  public void race() {
    for (int i = 0; i < gameCount; i++) {
      cars.race(new RandomRacingRule(RANDOM_BOUND));
      RacingGameOutputView.printRacingGameResult(cars);
    }
    RacingGameOutputView.printWinnerResult(cars);
  }

  private List<Car> initCars(String carNames) {
    return splitCarNames(carNames).stream()
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private List<String> splitCarNames(String carNames) {
    return Arrays.asList(carNames.split(SPLIT_FLAG));
  }

}
