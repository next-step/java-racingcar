package step4;

public class Main {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    int numOfMove = InputView.getNumOfMove();

    CarRacing carRacing = new CarRacing(carNames, numOfMove);
    carRacing.startRacing();
  }
}
