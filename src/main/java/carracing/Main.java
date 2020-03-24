package carracing;

import carracing.controller.CarRacingController;
import carracing.view.InputView;
import carracing.view.ResultView;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    List<String> carNames = inputView.getCarNames();
    Integer totalRound = inputView.getTotalRound();

    ResultView resultView = new CarRacingController().race(carNames, totalRound);
    resultView.show();
  }
}
