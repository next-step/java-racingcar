package racingcar.controller;

import static racingcar.util.RandomUtil.getRandomNumbers;

import racingcar.model.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarController {

  private RacingCarController() {
  }

  public static void run() {
    InputView.printCountQuestion();
    int count = InputView.getIntInput();
    InputView.printTimesQuestion();
    int times = InputView.getIntInput();

    Cars cars = Cars.makeCars(count);
    for (int i = 0; i < times; i++) {
      cars.move(getRandomNumbers(cars.size()));
      OutputView.printOutput(cars.getPositions());
    }
  }
}
