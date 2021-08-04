package study.step3;

import study.step3.model.strategy.RandomMoveStrategy;
import study.step3.model.view.Input;
import study.step3.model.RacingGame;
import study.step3.view.InputView;

public class Main {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    Input userInput = inputView.getUserInput();

    int carNumber = userInput.getCarNumber();
    int gameRound = userInput.getGameRound();

    RacingGame racingGame = new RacingGame(carNumber, gameRound);
    racingGame.start(new RandomMoveStrategy());
  }

}
