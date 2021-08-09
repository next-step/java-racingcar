package study.step4;

import study.step4.model.RacingGame;
import study.step4.model.view.Input;
import study.step4.view.InputView;

public class Main {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    Input userInput = inputView.getUserInput();

    int gameRound = userInput.getGameRound();
    String[] carNames = userInput.getCarNames();

    RacingGame racingGame = new RacingGame(carNames, gameRound);
    racingGame.start();
  }

}
