package study.carrace;


import study.util.Randomizer;
import study.util.RandomizerImpl;

public class RaceGameImpl implements RaceGame {

  private final int numberOfCar;
  private final int tryCount;
  private final Randomizer randomizer;

  public RaceGameImpl(int numberOfCar, int tryCount, Randomizer randomizer) {
    this.numberOfCar = numberOfCar;
    this.tryCount = tryCount;
    this.randomizer = randomizer;
  }

  @Override
  public Race[] process() {
    Race[] races = new Race[this.numberOfCar];

    for (int i = 0; i < this.numberOfCar; i++) {
      Race race = new Race(randomizer);
      for (int j = 0; j < tryCount; j++) {
        race.progress();
      }
      races[i] = race;
    }

    return races;
  }
}
