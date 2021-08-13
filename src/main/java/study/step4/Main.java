package study.step4;

import study.step4.model.RacingGame;
import study.step4.model.strategy.RandomMoveStrategy;
import study.step4.view.InputView;
import study.step4.view.ResultView;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();

    String carNames = inputView.getCarNamesInput();
    int carGameRound = inputView.getRacingGameRound();

    ResultView resultView = new ResultView();
    RacingGame racingGame = new RacingGame(carNames, carGameRound);

    for (int i = 0; i < carGameRound; i++) {
      racingGame.start(new RandomMoveStrategy());
      resultView.printGameResult(racingGame.getCars());
    }

    resultView.printWinner(racingGame.getCars().getWinners());
  }
}
