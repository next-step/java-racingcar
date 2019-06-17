package racingcar;

import java.util.Scanner;

public class RacingGameLauncher {

  static Scanner scanner = new Scanner(System.in);

  public static void start() {
    InputView.askNumberOfCar();
    int numberOfCar = scanner.nextInt();
    InputView.askNumberOfTimes();
    int numberOfTimes = scanner.nextInt();
    RacingGame racingGame = new RacingGame(numberOfCar);
    racingGame.start(numberOfTimes);
    ResultView.display(racingGame.result());
  }

  public static void main(String[] args) {
    RacingGameLauncher.start();
  }
}
