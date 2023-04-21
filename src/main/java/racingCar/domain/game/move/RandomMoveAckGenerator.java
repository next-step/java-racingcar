package racingCar.domain.game.move;

import util.RandomUtils;

public class RandomMoveAckGenerator implements MoveAckGenerator {

  public int generate () {
    return RandomUtils.getRandomSinglePositiveDigit();
  }
}
