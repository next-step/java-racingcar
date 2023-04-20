package racingCar.random;

import racingCar.domain.random.MoveAckGenerator;

public class ForwardOnlyMoveAckGenerator implements MoveAckGenerator {

  @Override
  public int generate() {
    return 4;
  }
}
