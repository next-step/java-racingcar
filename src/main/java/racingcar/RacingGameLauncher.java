package racingcar;

public class RacingGameLauncher {

  public static void launch() {
    Initializerer initializerer = new Initializerer();
    InputView.askNumberOfCar();
    initializerer.initNumberOfCar();
    InputView.askNumberOfTimes();
    initializerer.initNumberOfTimes();
    RacingGame racingGame = new RacingGame(initializerer);
    racingGame.start();
  }

  public static void main(String[] args) {
    RacingGameLauncher.launch();
  }
}
