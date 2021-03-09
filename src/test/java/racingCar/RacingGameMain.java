package racingCar;

public class RacingGameMain {

  public static void main(String[] args) {
    OutputView.printCarNumber();
    int carNumber = InputView.inputNumber();
    OutputView.printTryCount();
    int tryCount = InputView.inputNumber();
    RacingGame racingGame = new RacingGame(carNumber, tryCount);
    OutputView.printResult();
    racingGame.start();
  }

}
