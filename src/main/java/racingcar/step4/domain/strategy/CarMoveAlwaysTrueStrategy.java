package racingcar.step4.domain.strategy;

public class CarMoveAlwaysTrueStrategy implements CarMoveStrategy {

  public CarMoveAlwaysTrueStrategy() {
  }

  @Override
  public boolean isMovable() {
    return Boolean.TRUE;
  }
}
