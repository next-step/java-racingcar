package carracing;

import carracing.domain.CarRacingController;
import carracing.domain.service.RandomFourStepRacingService;
import carracing.ui.InputView;
import carracing.ui.RacingView;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    RacingView racingView = new RacingView(InputView.getInstance(), ResultView.getInstance());
    RandomFourStepRacingService carRacingService = new RandomFourStepRacingService();
    CarRacingController carRacingController = new CarRacingController(carRacingService, racingView);
    carRacingController.gameStart();
  }
}
