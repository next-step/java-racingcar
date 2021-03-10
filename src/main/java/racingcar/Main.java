package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;

public class Main {

  public static void main(String[] args) {
    RacingGame racingGame = new RacingGame();
    racingGame.readyGame(InputView.inputNameOfCars());
    racingGame.run(InputView.inputNumOfAttempt());
  }
}
