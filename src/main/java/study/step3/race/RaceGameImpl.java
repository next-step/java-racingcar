package study.step3.race;

import study.step3.car.Car;

public class RaceGameImpl implements RaceGame {

  private final Car[] cars;
  private final int tryCount;

  public RaceGameImpl(int numberOfCar, int tryCount) {
    this.cars = new Car[numberOfCar];
    this.tryCount = tryCount;
  }

  @Override
  public Race[] process() {
    Race[] races = new Race[cars.length];

    for (int i = 0; i < cars.length; i++) {
      Race race = new Race();
      for (int j = 0; j < tryCount; j++) {
        race.progress();
      }
      races[i] = race;
    }

    return races;
  }
}
