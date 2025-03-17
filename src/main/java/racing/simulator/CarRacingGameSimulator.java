package racing.simulator;

import racing.types.CarCount;
import racing.types.SimulateCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGameSimulator {

  private final RacingCarGroup racingCarGroup;

  public CarRacingGameSimulator(CarCount carCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    this.racingCarGroup = new RacingCarGroup(carCount, racingCarMovingStrategy);
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
