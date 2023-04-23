package study.racingcar.factory;

import java.util.List;
import study.racingcar.domain.Car;
import study.racingcar.domain.Race;

public class RaceFactory {

  private RaceFactory() {
  }

  public static Race createRace(List<Car> cars) {
    return new Race(cars);
  }
}
