package racingcar.domain;

@FunctionalInterface
public interface MoveStrategy {

    public boolean isMovable();
}
