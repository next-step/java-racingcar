package step45;

import step45.domain.CarRacing;
import step45.view.InputView;
import step45.view.ResultView;

public class Main {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    int numOfMove = InputView.getNumOfMove();

    CarRacing carRacing = new CarRacing(carNames, numOfMove);

    ResultView.printResultTitle();
    while (carRacing.isFinish()) {
      carRacing.moveAllCars();
      ResultView.printCurrentRoundResult(carRacing.getCarList());
      ResultView.printRoundDivider();
    }
    ResultView.printWinnerList(carRacing.getWinnerList());
  }
}
