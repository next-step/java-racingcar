package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RandomMovingStrategy;
import racingcar.ui.InputView;
import racingcar.util.SplitUtil;

public class RacingCarApplication {

  public static void main(String[] args) {
    InputView.printCarsQuestion();
    String carNames = InputView.getStringInput();
    InputView.printTimesQuestion();
    int times = InputView.getIntInput();

    RacingCarController carController = new RacingCarController(RandomMovingStrategy.getInstance());
    carController.run(SplitUtil.splitToList(carNames), times);
  }
}
