package racingCar.random;

import util.RandomUtils;

public class BaseRandomMoveAckGenerator implements RandomMoveAckGenerator {

  public int generate () {
    return RandomUtils.getRandomSinglePositiveDigit();
  }
}
