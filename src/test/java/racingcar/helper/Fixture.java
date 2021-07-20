package racingcar.helper;

import racingcar.strategy.MoveStrategy;

public class Fixture {
    private Fixture() {}

    public static MoveStrategy alwaysMoveStrategy() {
        return () -> true;
    }

    public static MoveStrategy neverMoveStrategy() {
        return () -> false;
    }
}
