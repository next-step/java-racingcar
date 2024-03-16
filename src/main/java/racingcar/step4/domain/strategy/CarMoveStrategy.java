package racingcar.step4.domain.strategy;

@FunctionalInterface
public interface CarMoveStrategy {
  boolean isMovable(MoveNumberGenerator moveNumberGenerator);
}
