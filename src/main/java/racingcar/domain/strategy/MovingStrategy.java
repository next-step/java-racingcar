package racingcar.domain.strategy;

@FunctionalInterface
public interface MovingStrategy {
    boolean isMovable();
}
