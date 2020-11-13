package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.RacingOperator;
import racinggame.domain.RandomScoreGenerator;
import racinggame.domain.ScoreGenerator;
import racinggame.racinggamexception.IllegalNumRoundException;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class GameClient {

  private static void runGame(RacingOperator racingOperator, int numRound) {
    validateRound(numRound);

    ScoreGenerator scoreGenerator = new RandomScoreGenerator();

    ResultView.printResultMessage();

    while (!racingOperator.finished(numRound)) {
      racingOperator.moves(scoreGenerator);
      ResultView.printCurrentStatusWithName(racingOperator.getCarsStatus());
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
