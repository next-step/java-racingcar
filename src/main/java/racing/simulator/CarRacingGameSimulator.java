package racing.simulator;

import racing.types.*;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final CarGroup carGroup;
  CarMovingStrategy carMovingStrategy;

  public CarRacingGameSimulator(List<CarName> carNames, CarMovingStrategy carMovingStrategy) {
    this.carGroup = new CarGroup(carNames);
    this.carMovingStrategy = carMovingStrategy;
  }

  public CarRacingGameSimulator(CarCount carCount, CarMovingStrategy carMovingStrategy) {
    this.carGroup = new CarGroup(carCount);
    this.carMovingStrategy = carMovingStrategy;
  }

  CarGroup getCarGroup() {
    return this.carGroup;
  }

  public CarRacingGameSimulateResult run(SimulateCount simulateCount) {
    List<List<Car>> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      carGroup.moveCars(carMovingStrategy);
      res.add(carGroup.copyCars());
    }

    carGroup.resetCars();
    return new CarRacingGameSimulateResult(res);
  }
}
