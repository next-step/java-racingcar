package racingrefactoring.domain;

public class RacingGame {

  private final CarGroup carGroup;

  public RacingGame(CarGroup carGroup) {
    this.carGroup = carGroup;
  }


  public CarGroup play(MoveStrategy moveStrategy) {
    return carGroup.moveCars(moveStrategy);
  }
}
