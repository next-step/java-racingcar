package step3;

public class Racer {

  private final int roundCount;
  private final int carCount;
  private final RaceEvaluator raceEvaluator;

  public Racer(int carCount, int roundCount, RaceEvaluator raceEvaluator) {
    this.roundCount = roundCount;
    this.carCount = carCount;
    this.raceEvaluator = raceEvaluator;
  }

  public Result race() {
    Result result = new Result();
    for (int round = 0; round < this.roundCount; round++) {
      result.record(round, proceed());
    }
    return result;
  }

  private Car[] proceed() {
    Car[] cars = new Car[this.carCount];
    for (int i = 0; i < this.carCount; i++) {
      cars[i] = new Car();
      if (raceEvaluator.evaluate()) {
        cars[i].move();
      }
    }
    return cars;
  }
}
