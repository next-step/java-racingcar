package study.racinggame.view;

import study.racinggame.domain.Racing;

public class ResultView {
  public static void main(String[] args) {
    Racing racing = new Racing(InputView.inputCarNumber(), InputView.inputTryNumber());

    racing.play();
  }
}
