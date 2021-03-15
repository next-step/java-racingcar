package racingCar;

public class RacingGameMain {

  public static void main(String[] args) {
    RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
    try {
      racingGame.start();
    } catch (OverCarNameLengthException e) {
      System.out.println(e.getMessage());
    }

  }

}
