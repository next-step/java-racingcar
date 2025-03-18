package racing.simulator;

import racing.types.*;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final CarGroup carGroup;
  RacingCarMovingStrategy racingCarMovingStrategy;

  public CarRacingGameSimulator(List<CarName> carNames, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.carGroup = new CarGroup(carNames);
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public CarRacingGameSimulator(CarCount carCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.carGroup = new CarGroup(carCount);
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public List<List<Car>> run(SimulateCount simulateCount) {
    List<List<Car>> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      carGroup.moveCars(racingCarMovingStrategy);
      res.add(carGroup.copyCars());
    }

    carGroup.resetCars();
    return res;
  }
}
