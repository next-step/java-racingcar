package racingrefactoring.domain;

public class RacingCarGame {

  private final CarGroup carGroup;

  public RacingCarGame(CarGroup carGroup) {
    this.carGroup = carGroup;
  }


  public CarGroup play(MoveStrategy moveStrategy) {
    return carGroup.moveCars(moveStrategy);
  }
}
