package racingCar.random;

import racingCar.domain.game.move.MoveAckGenerator;

public class HoldOnlyMoveAckGenerator implements MoveAckGenerator {

  @Override
  public int generate() {
    return 0;
  }
}
