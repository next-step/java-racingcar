package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class RacingCar {
  private int position = 0;       // 차가 이동한 위치

  public void tryToMove(MoveStrategy moveStrategy) {
    if (moveStrategy.decideMoveOrHold()) {
      this.position += moveStrategy.moveForward();
    }
  }

  public int position() {
    return this.position;
  }
}
