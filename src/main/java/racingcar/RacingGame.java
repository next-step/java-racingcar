package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

  public static void main(String[] args) {
    playGame();
  }

  private static void playGame() {
    int carNum = InputView.getUserInput(InputView.carInputMessage);
    int attemptNum = InputView.getUserInput(InputView.attemptInputMessage);

    GameController gameController = GameController.create(carNum, attemptNum);
    Game playedGame = gameController.proceedGame();
    ResultView resultView = ResultView.create(playedGame);
    resultView.printView();
  }
}
