package carracing;

import carracing.domain.entity.Challengers;
import carracing.domain.service.RandomFourStepRacingService;
import carracing.ui.InputView;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    InputView inputView = InputView.getInstance();
    ResultView resultView = ResultView.getInstance();

    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService();
    Challengers challengers = carRacingService.registerRacer(inputView.inputNumberOfCar());
    resultView.printResult(carRacingService.gameStart(inputView.inputTryCount(), challengers));
  }
}
