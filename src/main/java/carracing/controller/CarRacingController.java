package carracing.controller;

import carracing.model.Car;
import carracing.model.CarRacing;
import carracing.view.ResultView;
import java.util.List;

public class CarRacingController {

  public CarRacing race(List<String> carNames, Integer totalRound) {

    CarRacing carRacing = new CarRacing(carNames, totalRound);
    carRacing.race();

    return carRacing;
  }
}
