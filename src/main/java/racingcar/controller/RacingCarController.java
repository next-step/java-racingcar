package racingcar.controller;

import racingcar.model.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.RandomUtil;

public class RacingCarController {

  private RacingCarController() {
  }

  public static void run() {
    InputView.printCountQuestion();
    int count = InputView.getIntInput();
    InputView.printTimesQuestion();
    int times = InputView.getIntInput();

    Cars cars = new Cars(count);
    for (int i = 0; i < times; i++) {
      playOneTurn(cars);
      OutputView.printOutput(cars.getPositions());
      System.out.println();
    }
  }

  public static void playOneTurn(Cars cars) {
    cars.getCars().forEach(car -> car.moveOrStop(RandomUtil.getRandomNumber()));
  }
}
