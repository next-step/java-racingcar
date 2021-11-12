package carracing;

import carracing.domain.service.FourStandardCarRacingService;
import carracing.ui.InputView;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    InputView inputView = InputView.getInstance();
    ResultView resultView = ResultView.getInstance();

    FourStandardCarRacingService carRacingService
            = new FourStandardCarRacingService(inputView.inputNumberOfCar(), inputView.inputTryCount());
    resultView.printMessage(carRacingService.gameStart());
  }
}
