package carracing.controller;

import carracing.domain.entity.Cars;
import carracing.domain.service.CarRacingService;
import carracing.ui.RacingView;

public class CarRacingController {

  private final CarRacingService carRacingService;
  private final RacingView racingView;

  public CarRacingController(CarRacingService carRacingService, RacingView racingView) {
    this.carRacingService = carRacingService;
    this.racingView = racingView;
  }

  public void gameStart() {
    Cars cars = carRacingService.registerRacer(racingView.getNumberOfCar());

    racingView.printResult(carRacingService.gameStart(racingView.getRound(), cars));
  }

}
