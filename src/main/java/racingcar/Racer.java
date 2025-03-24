package racingcar;

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

  private Cars proceed() {
    Cars cars = new Cars(this.carCount);
    cars.move(raceEvaluator);
    return cars;
  }
}
