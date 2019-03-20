package racing.view;

import java.util.List;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.WinnerCars;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();
  private static final ConsoleResultView consoleResultView = new ConsoleResultView();

  private static final RacingGame racingGame = new RacingGame();

  public static void main(String[] args) {

    String carNames = consoleInputView.inputCarNames();
    List<Car> cars = name(carNames);

    int moveCount = consoleInputView.inputMoveCount();
    move(cars, moveCount);

    winner(cars);
  }

  private static void winner(List<Car> cars) {
    WinnerCars winnerCars = racingGame.winner(cars);
    consoleResultView.printWinner(winnerCars.getWinnerNames());
  }

  private static void move(List<Car> cars, int moveCount) {
    racingGame.startRacing(cars, moveCount);
    consoleResultView.printMoveResult(cars);
  }

  private static List<Car> name(String carNames) {
    return racingGame.generateCars(carNames);
  }
}
