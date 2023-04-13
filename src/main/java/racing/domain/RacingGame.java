package racing.domain;

import racing.util.RandomNumberGenerator;

public class RacingGame {

  private final CarGroup carGroup;

  public RacingGame(String carsName) {
    carGroup = new CarGroup(carsName);
  }

  /**
   * 게임을 한번 실행 한 경우를 의미한다.
   */
  public CarGroup play(MoveStrategy moveStrategy) {
    carGroup.moveCars(moveStrategy);
    return carGroup;
  }

  public String[] findWinners() {
    return carGroup.findWinners();
  }

}
