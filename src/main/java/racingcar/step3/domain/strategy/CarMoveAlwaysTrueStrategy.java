package racingcar.step3.domain.strategy;

public class CarMoveAlwaysTrueStrategy implements CarMoveStrategy {

  public CarMoveAlwaysTrueStrategy() {
  }

  @Override
  public boolean isMovable() {
    return Boolean.TRUE;
  }
}
