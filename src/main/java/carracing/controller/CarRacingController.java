package carracing.controller;

import carracing.model.Car;
import carracing.model.CarRacing;
import carracing.view.ResultView;
import java.util.List;

public class CarRacingController {

  public ResultView race(List<String> carNames, Integer totalRound) {

    List<Car> cars = new CarRacing(carNames, totalRound).race();

    return new ResultView(cars, totalRound);
  }
}
