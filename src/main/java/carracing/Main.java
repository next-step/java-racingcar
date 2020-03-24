package carracing;

import carracing.controller.CarRacingController;
import carracing.view.InputView;
import carracing.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    Integer carCount = inputView.getCarCount();
    Integer totalRound = inputView.getTotalRound();

    ResultView resultView = new CarRacingController().race(carCount, totalRound);
    resultView.show();
  }
}
