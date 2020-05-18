package racingcar;

import racingcar.controller.GameController;
import view.InputView;

public class RacingGame {

  public static void main(String[] args) {
    playGame();
  }

  private static void playGame() {
    int carNum = InputView.getUserInput(InputView.carInputMessage);
    int attemptNum = InputView.getUserInput(InputView.attemptInputMessage);

    GameController gameController = GameController.create(carNum, attemptNum);
    gameController.proceedGame();
  }
}
