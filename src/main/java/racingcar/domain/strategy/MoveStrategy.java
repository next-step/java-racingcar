package racingcar.domain.strategy;

@FunctionalInterface
public interface MoveStrategy {

    boolean isMovable();
}
