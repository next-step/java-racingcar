package study.racinggame;

import study.racinggame.domain.GameResult;
import study.racinggame.domain.RacingGame;
import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

public class RacingGameApplication {
  public static void main(String[] args) {
    int carNumber = InputView.inputCarNumber();
    int tryNumber = InputView.inputTryNumber();

    RacingGame racingGame = new RacingGame(carNumber);
    GameResult result = racingGame.play(tryNumber);
    ResultView.show(result);
  }
}
