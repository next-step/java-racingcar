package racingcar;

public class RacingGameLauncher {

  public static void launch() {
    InputView.askNumberOfCar();
    InputView.askNumberOfTimes();
  }

  public static void main(String[] args) {
    RacingGameLauncher.launch();
  }

}
