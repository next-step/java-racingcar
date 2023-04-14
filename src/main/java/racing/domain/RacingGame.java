package racing.domain;


public class RacingGame {

  private final CarGroup carGroup;
  private final MoveStrategy moveStrategy;

  public RacingGame(String carsName, MoveStrategy moveStrategy) {
    this.carGroup = new CarGroup(carsName);
    this.moveStrategy = moveStrategy;
  }

  /**
   * 게임을 한번 실행 한 경우를 의미한다.
   */
  public CarGroup play() {
    carGroup.moveCars(moveStrategy);
    return carGroup;
  }

  public String[] findWinners() {
    return carGroup.findWinners();
  }

}
