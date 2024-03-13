package racingcar.step3.domain.strategy;

public class CarMoveAlwaysFalseStrategy implements CarMoveStrategy {

  public CarMoveAlwaysFalseStrategy() {
  }

  @Override
  public boolean isMovable() {
    return Boolean.FALSE;
  }
}
