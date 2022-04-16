package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.MovingStrategy;
import racingcar.ui.OutputView;

public class RacingCarController {

  private static final int START_POSITION = 0;

  private MovingStrategy movingStrategy;

  public RacingCarController(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  public void run(List<String> carNames, int times) {
    validateTimes(times);
    Cars cars = Cars.createCars(carNames, START_POSITION);
    OutputView.printOutputStatement();
    for (int i = 0; i < times; i++) {
      cars.move(movingStrategy);
      OutputView.printOutput(cars.collectPositions());
    }
  }

  private static void validateTimes(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("시도 횟수를 올바르게 입력해주세요.");
    }
  }
}
