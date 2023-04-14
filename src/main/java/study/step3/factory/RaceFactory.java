package study.step3.factory;

import study.step3.domain.Race;

public class RaceFactory {

  private RaceFactory() {
  }

  public static Race createRace(String[] nameOfCars) {
    return new Race(CarFactory.createCars(nameOfCars));
  }
}
