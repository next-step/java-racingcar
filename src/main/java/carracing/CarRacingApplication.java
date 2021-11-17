package carracing;

import carracing.controller.CarRacingController;
import carracing.domain.service.RandomFourStepRacingService;
import carracing.ui.InputView;
import carracing.ui.RacingViewImpl;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    RacingViewImpl racingView = new RacingViewImpl(InputView.getInstance(), ResultView.getInstance());
    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService();

    CarRacingController carRacingController = new CarRacingController(carRacingService, racingView);
    carRacingController.gameStart();
  }
}
