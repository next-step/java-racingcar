package study.racingcar.factory;

import java.util.List;
import study.racingcar.domain.Car;
import study.racingcar.domain.Race;

public class RaceFactory {

  private RaceFactory() {
  }

  public static Race createRace(final List<Car> cars) {
    return new Race(cars);
  }
}
