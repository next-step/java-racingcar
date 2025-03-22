package racing.simulator;

import racing.types.*;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private CarGroup carGroup;
  CarMovingStrategy carMovingStrategy;

  public CarRacingGameSimulator(List<CarName> carNames, CarMovingStrategy carMovingStrategy) {
    this.carGroup = new CarGroup();
    for (CarName carName : carNames) {
      carGroup.add(Car.valueOf(carName));
    }
    this.carMovingStrategy = carMovingStrategy;
  }

  public CarRacingGameSimulator(CarCount carCount, CarMovingStrategy carMovingStrategy) {
    this.carGroup = carCount.toCarGroup();
    this.carMovingStrategy = carMovingStrategy;
  }

  public CarRacingGameSimulateResult run(SimulateCount simulateCount) {
    List<CarGroup> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      carGroup = carGroup.toTryMoveCarGroup(carMovingStrategy);
      res.add(carGroup);
    }

    return CarRacingGameSimulateResult.valueOf(res);
  }

  public void reset() {
    carGroup.resetCars();
  }
}
