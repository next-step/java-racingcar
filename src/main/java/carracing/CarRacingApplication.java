package carracing;

import carracing.domain.CarRacingService;
import carracing.ui.InputView;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    CarRacingService carRacingService = new CarRacingService(new ResultView());
    carRacingService.doRacing(inputView.inputNumberOfCar(), inputView.inputTryCount());
  }

}
