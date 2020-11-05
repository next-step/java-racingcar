package racingGame;

import racingGame.View.InputView;
import racingGame.View.ResultView;

public class GameClient {

  private static void runGame(Cars cars, int numRound) {
    int currentRound = 1;
    ScoreGenerator scoreGenerator = new RandomScoreGenerator();

    ResultView.printResultMessage();

    for (; !isFinished(currentRound, numRound); currentRound += 1) {
      cars.moves(scoreGenerator);
      ResultView.printStatus(cars);
    }
  }

  private static boolean isFinished(int currentRound, int numRound) {
    return currentRound > numRound;
  }

  public static void main(String[] args) {
    int numCar;
    int numRound;
    Cars cars;

    numCar = InputView.askNumCar();
    numRound = InputView.askNumRound();

    cars = Cars.of(numCar);
    runGame(cars, numRound);
  }

}
