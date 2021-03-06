package racing.util;

public class Validation {

  public Boolean isZero(int[] carCountAndTurnCount) {
    return carCountAndTurnCount[0] == 0 || carCountAndTurnCount[1] == 0;
  }
}
