package study.carrace;


import study.car.Car;
import study.util.Randomizer;
import study.util.RandomizerImpl;

public class RaceGameImpl implements RaceGame {

  private final Car[] cars;
  private final int tryCount;
  private final Randomizer randomizer;

  public RaceGameImpl(Car[] cars, int tryCount, Randomizer randomizer) {
    this.cars = cars;
    this.tryCount = tryCount;
    this.randomizer = randomizer;
  }

  @Override
  public Race[] process() {
    Race[] races = new Race[this.cars.length];

    for (int i = 0; i < this.cars.length; i++) {
      Race race = new Race(randomizer);
      for (int j = 0; j < tryCount; j++) {
        race.progress();
      }
      races[i] = race;
    }

    return races;
  }
}
