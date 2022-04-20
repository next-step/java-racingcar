package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RandomMovingStrategy;
import racingcar.view.InputView;

public class RacingCarApplication {

  public static void main(String[] args) {
    InputView.printCarsQuestion();
    String carNames = InputView.getStringInput();
    InputView.printTimesQuestion();
    int times = InputView.getIntInput();

    RacingCarController carController = new RacingCarController(RandomMovingStrategy.getInstance());
    carController.run(carNames, times);
  }
}
