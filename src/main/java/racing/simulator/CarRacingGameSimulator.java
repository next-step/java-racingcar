package racing.simulator;

import racing.types.*;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final RacingCarGroup racingCarGroup;
  RacingCarMovingStrategy racingCarMovingStrategy;

  public CarRacingGameSimulator(List<RacingCarName> racingCarNames, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(racingCarNames);
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public CarRacingGameSimulator(RacingCarCount racingCarCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(racingCarCount);
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public List<List<RacingCar>> run(SimulateCount simulateCount) {
    List<List<RacingCar>> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      racingCarGroup.moveCars(racingCarMovingStrategy);
      res.add(racingCarGroup.copyCars());
    }

    racingCarGroup.resetCars();
    return res;
  }
}
