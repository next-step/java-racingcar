package racingGame;

import racingGame.View.InputView;
import racingGame.View.ResultView;
import racingGame.racingGameException.IllegalNumRoundException;

public class GameClient {

  private static void runGame(RacingOperator racingOperator, int numRound) {
    validateRound(numRound);

    int currentRound = 1;

    ResultView.printResultMessage();

    while (!isFinished(currentRound, numRound)) {
      racingOperator.moves();
      ResultView.printCurrentStatusWithName(racingOperator.getCurrentCarsStatus());
      currentRound += 1;
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
