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
    String[] names = InputView.getUserStringInput(InputView.carInputMessage).split(", ");
    int attemptNum = InputView.getUserNumInput(InputView.attemptInputMessage);

    GameController gameController = GameController.create(attemptNum, names);
    Game playedGame = gameController.proceedGame();
    ResultView resultView = ResultView.create(playedGame);
    resultView.printView();
  }
}
