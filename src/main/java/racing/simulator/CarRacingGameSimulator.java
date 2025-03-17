package racing.simulator;

import racing.types.RacingCarCount;
import racing.types.SimulateCount;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGameSimulator {

  private final RacingCarGroup racingCarGroup;

  public CarRacingGameSimulator(RacingCarCount racingCarCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(racingCarCount, racingCarMovingStrategy);
  }

  public List<List<Integer>> run(SimulateCount simulateCount) {
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < simulateCount.getCount(); i++) {
      racingCarGroup.moveCars();
      res.add(racingCarGroup.getCarLocations());
    }

    racingCarGroup.resetCars();
    return res;
  }
}
