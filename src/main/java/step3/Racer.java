package step3;

public class Racer {

  private final int numRounds;
  private final int numCars;
  private final RaceEvaluator raceEvaluator;

  public Racer(int numCars, int numRounds, RaceEvaluator raceEvaluator) {
    this.numRounds = numRounds;
    this.numCars = numCars;
    this.raceEvaluator = raceEvaluator;
  }

  public Result race() {
    Result result = new Result();
    for (int round = 0; round < this.numRounds; round++) {
      result.record(round, proceed());
    }
    return result;
  }

  private Car[] proceed() {
    Car[] cars = new Car[this.numCars];
    for (int i = 0; i < this.numCars; i++) {
      cars[i] = new Car();
      if (raceEvaluator.evaluate()) {
        cars[i].move();
      }
    }
    return cars;
  }
}
