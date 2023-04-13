package study.racinggame;

import study.racinggame.domain.GameResult;
import study.racinggame.domain.RacingGame;
import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

import java.util.List;

public class RacingGameApplication {
  public static void main(String[] args) {
    List<String> carNumber = InputView.inputCarNames();
    int tryNumber = InputView.inputTryNumber();

    RacingGame racingGame = new RacingGame(carNumber);
    GameResult result = racingGame.play(tryNumber);
    ResultView.show(result);
  }
}
