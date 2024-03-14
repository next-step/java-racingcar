package racingcar.step4.domain.strategy;

public class CarMoveAlwaysFalseStrategy implements CarMoveStrategy {

  public CarMoveAlwaysFalseStrategy() {
  }

  @Override
  public boolean isMovable() {
    return Boolean.FALSE;
  }
}
