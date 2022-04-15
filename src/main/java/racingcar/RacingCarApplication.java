package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RandomMovingStrategy;
import racingcar.ui.InputView;

public class RacingCarApplication {

  public static void main(String[] args) {
    InputView.printCountQuestion();
    int count = InputView.getIntInput();
    InputView.printTimesQuestion();
    int times = InputView.getIntInput();

    RacingCarController carController = new RacingCarController(RandomMovingStrategy.getInstance());
    carController.run(count, times);
  }
}
