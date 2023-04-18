package racingCar.random;

import racingCar.random.RandomMoveAckGenerator;

public class ForwardOnlyMoveAckGenerator implements RandomMoveAckGenerator {

  @Override
  public int generate() {
    return 4;
  }
}
