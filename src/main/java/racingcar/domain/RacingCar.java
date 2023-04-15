package racingcar.domain;

import racingcar.repository.CarInterface;
import racingcar.repository.MoveStrategy;

public class RacingCar implements CarInterface {
  private int position = 0;       // 차가 이동한 위치

  public RacingCar() {

  }

  @Override
  public void move(MoveStrategy moveStrategy) {
    if(moveStrategy.decideMoveOrHold()) {
      this.position += moveStrategy.moveForward();
    }

  }

  @Override
  public int position() {
    return this.position;
  }
}
