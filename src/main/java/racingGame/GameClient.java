package racingGame;

import java.util.List;
import javafx.util.Pair;
import racingGame.View.InputView;
import racingGame.View.ResultView;

public class GameClient {

  private static void runGame(RacingOperator racingOperator, int numRound) {
    int currentRound = 1;

    ResultView.printResultMessage();

    for (; !isFinished(currentRound, numRound); currentRound += 1) {
      racingOperator.moves();
      // List<Integer> status = carOperator.getPositions();
      // ResultView.printCurrentStatus(status);
      List<Pair<String, Integer>> status = racingOperator.getCurrentCarsStatus();
      ResultView.printCurrentStatusWithName(status);
    }

    ResultView.printWinner(racingOperator.extractWinners());
  }

  private static boolean isFinished(int currentRound, int numRound) {
    return currentRound > numRound;
  }

  public static void main(String[] args) {
    String rawInput;
    List<String> names;
    int numRound;
    Cars cars;
    RacingOperator racingOperator;

    rawInput = InputView.askUserNames();
    names = InputView.parseRawInput(rawInput);

    numRound = InputView.askNumRound();

    cars = Cars.of(names);
    racingOperator = RacingOperator.of(cars);

    runGame(racingOperator, numRound);
  }

}
