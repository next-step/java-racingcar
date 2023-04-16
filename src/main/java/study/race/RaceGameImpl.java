package study.race;


public class RaceGameImpl implements RaceGame {

  private final int numberOfCar;
  private final int tryCount;

  public RaceGameImpl(int numberOfCar, int tryCount) {
    this.numberOfCar = numberOfCar;
    this.tryCount = tryCount;
  }

  @Override
  public Race[] process() {
    Race[] races = new Race[this.numberOfCar];

    for (int i = 0; i < this.numberOfCar; i++) {
      Race race = new Race();
      for (int j = 0; j < tryCount; j++) {
        race.progress();
      }
      races[i] = race;
    }

    return races;
  }
}
