package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingGameLauncher {

  static Scanner scanner = new Scanner(System.in);

  public static void start() {
    InputView.askNameOfCars();
    String inputCarNames = scanner.next();
    String[] carNames = Parser.carNameParse(inputCarNames);
    InputView.askNumberOfTimes();
    int numberOfTimes = scanner.nextInt();

    RacingGame racingGame = new RacingGame(carNames);
    for (int i = 0; i < numberOfTimes; i++) {
      List<Car> record = racingGame.start();
      ResultView.display(record);
    }

  }

  public static void main(String[] args) {
    RacingGameLauncher.start();
  }
}
