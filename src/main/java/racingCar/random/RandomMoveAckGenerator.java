package racingCar.random;

import util.RandomUtils;

public class RandomMoveAckGenerator implements MoveAckGenerator {

  public int generate () {
    return RandomUtils.getRandomSinglePositiveDigit();
  }
}
