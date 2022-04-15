package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MovingStrategy;
import racingcar.ui.OutputView;

public class RacingCarController {

  private MovingStrategy movingStrategy;

  public RacingCarController(MovingStrategy movingStrategy) {
    this.movingStrategy = movingStrategy;
  }

  public void run(int count, int times) {
    Cars cars = Cars.createCars(count);
    for (int i = 0; i < times; i++) {
      cars.move(movingStrategy);
      OutputView.printOutput(cars.collectPositions());
    }
  }
}
