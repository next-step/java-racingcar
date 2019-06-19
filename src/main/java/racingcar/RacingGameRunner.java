package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameRunner {

  public static void main(String[] args) {

    InputView inputView = new ConsoleInputView();
    ResultView resultView = new ConsoleResultView();

    RacingController racingController = new RacingController(inputView, resultView);
    racingController.startRacing();
  }
}
