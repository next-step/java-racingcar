package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.MovingStrategy;
import racingcar.ui.ResultView;

public class RacingCarController {

  private static final int START_POSITION = 0;

  private final MovingStrategy movingStrategy;

  public RacingCarController(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  public void run(List<String> carNames, int times) {
    validateTimes(times);

    Cars cars = Cars.createCars(carNames, START_POSITION);
    ResultView.printOutputStatement();
    for (int i = 0; i < times; i++) {
      playOneTurn(cars);
    }
    ResultView.printWinners(cars.findWinners());
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
}
