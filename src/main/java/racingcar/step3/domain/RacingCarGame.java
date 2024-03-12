package racingcar.step3.domain;

import racingcar.step3.dto.RacingCarGameResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

  private final int round;
  private final List<Car> cars;

  public RacingCarGame(int round, List<Car> cars) {
    this.round = round;
    this.cars = cars;
  }

  public RacingCarGameResultDto start() {
    cars.forEach(Car::move);
    List<RacingCarGameResultDto.RaceRecord> raceRecord = cars.stream()
        .map(car -> new RacingCarGameResultDto.RaceRecord(car.getCarName(), car.getPosition()))
        .collect(Collectors.toList());

    return new RacingCarGameResultDto(round, raceRecord);
  }
}
