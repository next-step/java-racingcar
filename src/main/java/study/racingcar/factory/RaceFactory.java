package study.racingcar.factory;

import study.racingcar.domain.Race;

public class RaceFactory {

  private RaceFactory() {
  }

  public static Race createRace(String[] nameOfCars) {
    return new Race(CarFactory.createCars(nameOfCars));
  }
}
