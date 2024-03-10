package racingcar.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private final int rounds;
  private final List<Car> cars;

  public RacingCarGame(int rounds, List<Car> cars) {
    this.rounds = rounds;
    this.cars = cars;
  }

  public List<RacingCarGameResult> start() {
    List<RacingCarGameResult> results = new ArrayList<>();
    for (int round = 1; round <= rounds; round++) {
      results.add(racing(round));
    }

    return results;
  }

  private RacingCarGameResult racing(int round) {
    List<RacingCarGameResult.RaceRecord> records = new ArrayList<>();
    cars.forEach(car -> {
      car.move();
      records.add(new RacingCarGameResult.RaceRecord(car, car.getMoveCount()));
    });

    return new RacingCarGameResult(round, records);
  }
}
