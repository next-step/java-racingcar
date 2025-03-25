package racingcar;

public class Racer {

  private final int roundCount;
  private final Names carNames;
  private final RaceEvaluator raceEvaluator;

  public Racer(Names carNames, int roundCount, RaceEvaluator raceEvaluator) {
    this.roundCount = roundCount;
    this.carNames = carNames;
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
    Cars cars = new Cars(this.carNames);
    cars.moveAll(raceEvaluator);
    return cars;
  }
}
