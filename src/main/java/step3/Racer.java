package step3;

import java.util.HashMap;
import java.util.Map;

public class Racer {

  private final int numTry;
  private final int numCars;
  private final RaceEvaluator raceEvaluator;

  public Racer(int numCars, int numTry, RaceEvaluator raceEvaluator) {
    this.numTry = numTry;
    this.numCars = numCars;
    this.raceEvaluator = raceEvaluator;
  }

  public Racer(int numCars, int numTry) {
    this(numCars, numTry, new RaceEvaluator());
  }

  public Map<Integer, int[]> race() {
    Map<Integer, int[]> result = new HashMap<>();
    for (int i = 0; i < this.numTry; i++) {
      calculate(result, i);
    }
    return result;
  }

  private void calculate(Map<Integer, int[]> result, int round) {
    int[] cars = getPreviousResult(result, round);
    proceed(cars);
    result.put(round, cars);
  }

  private void proceed(int[] cars) {
    for (int index = 0; index < this.numCars; index++) {
      if (raceEvaluator.evaluate()) {
        cars[index]++;
      }
    }
  }

  private int[] getPreviousResult(Map<Integer, int[]> result, int round) {
    if (round == 0) {
      return new int[this.numCars];
    }
    return result.get(round - 1).clone();
  }
}
