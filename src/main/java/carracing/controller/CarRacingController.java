package carracing.controller;

import carracing.model.Car;
import carracing.model.CarRacing;
import carracing.view.ResultView;
import java.util.List;

public class CarRacingController {

  public ResultView race(Integer carCount, Integer totalRound) {

    List<Car> cars = new CarRacing(carCount, totalRound).race();

    return new ResultView(cars, totalRound);
  }
}
