package racingcar.step3.domain.strategy;

@FunctionalInterface
public interface CarMoveStrategy {
  boolean isMovable();
}
