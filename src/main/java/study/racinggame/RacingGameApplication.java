package study.racinggame;

import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

public class RacingGameApplication {
  public static void main(String[] args) {
    ResultView resultView = new ResultView(InputView.inputCarNumber(), InputView.inputTryNumber());

    resultView.play();
  }
}
