package racingcar.utils;

import racingcar.strategies.MoveStrategy;

public class RandomNumberUtil {

    private RandomNumberUtil() {}

    public static boolean isMovable(MoveStrategy moveStrategy) {
        return moveStrategy.checkMovement();
    }

}
