package racingcar.step4;

import racingcar.step4.controller.RacingCarGameController;
import racingcar.step4.view.InputView;
import racingcar.step4.view.ResultView;

public class RacingCarGameApplication {
  public static void main(String[] args) {
    RacingCarGameController racingCarGameController = new RacingCarGameController(new InputView(), new ResultView());
    racingCarGameController.run();
  }
}
