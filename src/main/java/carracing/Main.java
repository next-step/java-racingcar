package carracing;

import carracing.controller.CarRacingController;
import carracing.model.CarRacing;
import carracing.view.InputView;
import carracing.view.ResultView;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    List<String> carNames = inputView.getCarNames();
    Integer totalRound = inputView.getTotalRound();

    CarRacing carRacing = new CarRacingController().race(carNames, totalRound);

    new ResultView(carRacing.getCars(), carRacing.getTotalRound()).show();
  }
}
