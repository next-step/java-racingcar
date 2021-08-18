package step45;

import step45.domain.CarRacing;
import step45.domain.RandomMoveStrategy;
import step45.view.InputView;
import step45.view.ResultView;

public class Main {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    int tryNum = InputView.getTryNum();

    CarRacing carRacing = new CarRacing(carNames, tryNum, new RandomMoveStrategy());

    ResultView.printResultTitle();
    while (!carRacing.isFinish()) {
      carRacing.moveCars();
      ResultView.printCurrentRoundResult(carRacing.getCars());
      ResultView.printRoundDivider();
    }
    ResultView.printWinnerList(carRacing.getWinners());
  }
}
