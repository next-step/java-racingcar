package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.domain.Winners;
import racingcar.view.ResultView;

public class RacingCarController {

  private static final int START_POSITION = 0;
  private static final String DEFAULT_DELIMITER = ",";

  private final MovingStrategy movingStrategy;

  public RacingCarController(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  public void run(String carNames, int times) {
    validateTimes(times);

    Cars cars = Cars.createCars(splitToList(carNames), START_POSITION);
    ResultView.printOutputStatement();
    for (int i = 0; i < times; i++) {
      playOneTurn(cars);
    }
    ResultView.printWinners(Winners.findWinners(cars));
  }

  private void playOneTurn(Cars cars) {
    cars.move(movingStrategy);
    ResultView.printOutput(cars);
  }

  private static void validateTimes(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("시도 횟수를 올바르게 입력해주세요.");
    }
  }

  private static List<String> splitToList(String input) {
    return Arrays.asList(input.split(DEFAULT_DELIMITER));
  }
}
