package racingcar.strategyTest;

@FunctionalInterface
public interface MoveStrategy {
    boolean decideMoveOrHold();
}
