package racingcar;

import racingcar.view.InputView;

public class Main {

  public static void main(String[] args) {
    RacingGame racingGame = new RacingGame();
    racingGame.readyGame(InputView.inputNumOfCar());
    racingGame.run(InputView.inputNumOfAttempt());
  }
}
