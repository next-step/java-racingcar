package carracing;

import carracing.domain.service.RandomFourStepRacingService;
import carracing.ui.InputView;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    InputView inputView = InputView.getInstance();
    ResultView resultView = ResultView.getInstance();

    RandomFourStepRacingService carRacingService
            = new RandomFourStepRacingService(inputView.inputNumberOfCar(), inputView.inputTryCount());
    resultView.printResult(carRacingService.gameStart());
  }
}
