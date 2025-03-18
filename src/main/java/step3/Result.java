package step3;

import java.util.HashMap;
import java.util.Map;

public class Result {

  Map<Integer, Car[]> result;

  public Result() {
    result = new HashMap<>();
  }

  public Car[] merge(int round, Car[] roundResult) {
    if (round == 0) {
      return roundResult;
    }

    for (int i = 0; i < roundResult.length; i++) {
      roundResult[i].mergeScore(result.get(round - 1)[i].getScore());
    }

    return roundResult;
  }

  public void record(int round, Car[] roundResult) {
    result.put(round, merge(round, roundResult));
  }

  public int size() {
    return result.size();
  }

  public Car[] get(int round) {
    return result.get(round);
  }
}
