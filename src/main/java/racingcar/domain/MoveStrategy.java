package racingcar.domain;

@FunctionalInterface
public interface MoveStrategy {
    Position move(Position position);
}
