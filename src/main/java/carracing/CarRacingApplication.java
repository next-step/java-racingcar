package carracing;

import carracing.controller.CarRacingController;
import carracing.domain.service.CarRacingService;
import carracing.domain.service.CarRacingServiceImpl;
import carracing.domain.service.MoveStrategy;
import carracing.domain.service.RandomFourStepMoveStrategy;
import carracing.ui.InputView;
import carracing.ui.RacingView;
import carracing.ui.RacingViewImpl;
import carracing.ui.ResultView;

public class CarRacingApplication {

  public static void main(String[] args) {
    RacingView racingView = new RacingViewImpl(InputView.getInstance(), ResultView.getInstance());
    MoveStrategy moveStrategy = new RandomFourStepMoveStrategy();
    CarRacingService carRacingService = new CarRacingServiceImpl(moveStrategy);
    CarRacingController carRacingController = new CarRacingController(carRacingService, racingView);

    carRacingController.gameStart();
  }
}
