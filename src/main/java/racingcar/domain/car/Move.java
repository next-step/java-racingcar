package racingcar.domain.car;

import racingcar.domain.RandomManager;

public class Move {

    private static final int BOUND = 4;

    public static boolean isSatisfiedMoveCondition() {
        if (RandomManager.get() >= BOUND) {
            return true;
        }
        return false;
    }
}
