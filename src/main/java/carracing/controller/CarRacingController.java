package carracing.controller;

import carracing.domain.entity.Challengers;
import carracing.domain.service.CarRacingService;
import carracing.ui.RacingViewImpl;

public class CarRacingController {

  private final CarRacingService carRacingService;
  private final RacingViewImpl racingView;

  public CarRacingController(CarRacingService carRacingService, RacingViewImpl racingView) {
    this.carRacingService = carRacingService;
    this.racingView = racingView;
  }

  public void gameStart() {
    Challengers challengers = carRacingService.registerRacer(racingView.getNumberOfCar());

    racingView.printResult(carRacingService.gameStart(racingView.getRound(), challengers));
  }

}
