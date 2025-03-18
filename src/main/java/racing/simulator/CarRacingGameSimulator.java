package racing.simulator;

import racing.types.*;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final RacingCarGroup racingCarGroup;

  public CarRacingGameSimulator(List<RacingCarName> racingCarNames, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(racingCarNames, racingCarMovingStrategy);
  }

  public CarRacingGameSimulator(RacingCarCount racingCarCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(racingCarCount, racingCarMovingStrategy);
  }

  public List<List<RacingCar>> run(SimulateCount simulateCount) {
    List<List<RacingCar>> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      racingCarGroup.moveCars();
      res.add(racingCarGroup.copyCars());
    }

    racingCarGroup.resetCars();
    return res;
  }
}
