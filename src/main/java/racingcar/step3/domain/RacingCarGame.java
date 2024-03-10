package racingcar.step3.domain;

import racingcar.step3.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private static final int RANDOM_NUMBER_BOUND = 10;

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
      car.move(RandomNumberUtil.generate(RANDOM_NUMBER_BOUND));
      records.add(new RacingCarGameResult.RaceRecord(car, car.getMoveCount()));
    });

    return new RacingCarGameResult(round, records);
  }
}
