package racingGame;

import racingGame.View.InputView;
import racingGame.View.ResultView;
import racingGame.racingGameException.IllegalNumRoundException;

public class GameClient {

  private static void runGame(RacingOperator racingOperator, int numRound) {
    validateRound(numRound);

    ScoreGenerator scoreGenerator = new RandomScoreGenerator();

    ResultView.printResultMessage();

    while (!racingOperator.finished(numRound)) {
      racingOperator.moves(scoreGenerator);
      ResultView.printCurrentStatusWithName(racingOperator.getCurrentCarsStatus());
    }

    ResultView.printWinner(racingOperator.extractWinners());
  }

  private static void validateRound(int numRound) {
    if (numRound < 1) {
      throw new IllegalNumRoundException();
    }
  }

  private static boolean isFinished(int currentRound, int numRound) {
    return currentRound > numRound;
  }

  public static void main(String[] args) {
    String names = InputView.askUserNames();
    int numRound = InputView.askNumRound();

    Cars cars = Cars.of(names);
    RacingOperator racingOperator = RacingOperator.of(cars);

    runGame(racingOperator, numRound);
  }
}
