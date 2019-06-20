package racingcar;

import java.util.List;
import java.util.Scanner;
import racingcar.controller.RacingGame;
import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameLauncher {

  static Scanner scanner = new Scanner(System.in);

  public static void start() {
    InputView.askNameOfCars();
    String inputCarNames = scanner.next();
    String[] carNames = Parser.parseCarNames(inputCarNames);
    InputView.askNumberOfTimes();
    int numberOfTimes = scanner.nextInt();

    RacingGame racingGame = new RacingGame(carNames);
    for (int i = 0; i < numberOfTimes; i++) {
      List<Car> record = racingGame.start();
      ResultView.displayRecord(record);
    }

    Winners winners = racingGame.announceWinners();
    ResultView.displayWinnersOneLine(winners);

  }

  public static void main(String[] args) {
    RacingGameLauncher.start();
  }
}
