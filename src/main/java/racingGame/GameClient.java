package racingGame;

import java.util.List;
import javafx.util.Pair;
import racingGame.View.InputView;
import racingGame.View.ResultView;

public class GameClient {

  private static void runGame(CarOperator carOperator, int numRound) {
    int currentRound = 1;

    ResultView.printResultMessage();

    for (; !isFinished(currentRound, numRound); currentRound += 1) {
      carOperator.moves();
      // List<Integer> status = carOperator.getPositions();
      // ResultView.printCurrentStatus(status);
      List<Pair<String, Integer>> status = carOperator.getCurrentCarsStatus();
      ResultView.printCurrentStatusWithName(status);
    }

    ResultView.printWinner(carOperator.extractWinners());
  }

  private static boolean isFinished(int currentRound, int numRound) {
    return currentRound > numRound;
  }

  public static void main(String[] args) {
    String rawInput;
    List<String> names;
    int numRound;
    Cars cars;
    CarOperator carOperator;

    rawInput = InputView.askUserNames();
    names = InputView.parseRawInput(rawInput);

    numRound = InputView.askNumRound();

    cars = Cars.of(names);
    carOperator = CarOperator.of(cars);

    runGame(carOperator, numRound);
  }

}
