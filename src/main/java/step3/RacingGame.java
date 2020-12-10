package step3;

import step3.domain.Cars;
import step3.service.RandomRacingRule;
import step3.view.RacingGameOutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

  private static final String SPLIT_FLAG = ",";
  private static final int RANDOM_BOUND = 10;

  public void start(String carNames, int gameCount) {
    Cars cars = new Cars(splitCarNames(carNames));
    for (int i = 0; i < gameCount; i++) {
      cars.race(new RandomRacingRule(RANDOM_BOUND));
      RacingGameOutputView.printRacingGameResult(cars);
    }
    RacingGameOutputView.printWinnerResult(cars);
  }

  private List<String> splitCarNames(String carNames) {
    return Arrays.asList(carNames.split(SPLIT_FLAG));
  }

}
