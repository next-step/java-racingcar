package step3;

import java.util.HashMap;
import java.util.Map;

public class Result {

  private final Map<Integer, Cars> result;

  public Result() {
    result = new HashMap<>();
  }

  public Cars merge(int round, Cars roundResult) {
    if (round == 0) {
      return roundResult;
    }

    for (int i = 0; i < roundResult.size(); i++) {
      roundResult.getCar(i).addScore(result.get(round - 1).getCar(i).getScore());
    }

    return roundResult;
  }

  public void record(int round, Cars roundResult) {
    result.put(round, merge(round, roundResult));
  }

  public int size() {
    return result.size();
  }

  public Cars get(int round) {
    return result.get(round);
  }
}
