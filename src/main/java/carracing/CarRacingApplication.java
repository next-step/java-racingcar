package carracing;

import carracing.controller.CarRacingController;
import carracing.domain.service.CarRacingService;
import carracing.domain.service.RandomFourStepRacingService;
import carracing.ui.InputView;
import carracing.ui.RacingView;
import carracing.ui.RacingViewImpl;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    RacingView racingView = new RacingViewImpl(InputView.getInstance(), ResultView.getInstance());
    CarRacingService carRacingService = new RandomFourStepRacingService();

    CarRacingController carRacingController = new CarRacingController(carRacingService, racingView);
    carRacingController.gameStart();
  }
}
