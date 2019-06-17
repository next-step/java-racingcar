package racingcar;

public class RacingGameLauncher {

  public static void launch() {
    Initializerer initializerer = new Initializerer();
    InputView.askNumberOfCar();
    initializerer.initNumberOfCar();
    InputView.askNumberOfTimes();
    initializerer.initNumberOfTimes();
  }

  public static void main(String[] args) {
    RacingGameLauncher.launch();
  }

}
