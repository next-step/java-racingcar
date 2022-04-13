package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
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
      cars.move(getRandomNumbers(count));
      OutputView.printOutput(cars.getPositions());
    }
  }

  private static List<Integer> getRandomNumbers(int count) {
    List<Integer> randomNumbers = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      randomNumbers.add(RandomUtil.getRandomNumber());
    }
    return randomNumbers;
  }
}
