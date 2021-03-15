package racingCar;

public class RacingGameMain {

  public static void main(String[] args) {
    RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
    racingGame.start();
  }

}
