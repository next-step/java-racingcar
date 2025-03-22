package racingcar.domain;

@FunctionalInterface
public interface RacingCarMoveStrategy {
    boolean isMovable();
}
