package racingCar.random;

import racingCar.domain.game.move.MoveAckGenerator;

public class ForwardOnlyMoveAckGenerator implements MoveAckGenerator {

  @Override
  public int generate() {
    return 4;
  }
}
