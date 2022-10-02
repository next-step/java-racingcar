package racingcar.backend.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean movable();
}
