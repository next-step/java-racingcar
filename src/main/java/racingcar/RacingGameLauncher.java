package racingcar;

import java.util.Scanner;

public class RacingGameLauncher {

  static Scanner scanner = new Scanner(System.in);

  public static void start() {
    Record record = new Record();

    InputView.askNameOfCars();
    String inputCarNames = scanner.next();
    String[] carNames = Parser.carNameParse(inputCarNames);
    InputView.askNumberOfTimes();
    int numberOfTimes = scanner.nextInt();

    RacingGame racingGame = new RacingGame(carNames);
    racingGame.start(numberOfTimes, record);

    ResultView.display(record);
  }

  public static void main(String[] args) {
    RacingGameLauncher.start();
  }
}
