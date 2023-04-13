package racingcar;

import java.util.Random;

public class FourOverTenMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int RATIO_OVER_TEN = 4;

    public boolean isMovable() {
        return toBool(RANDOM.nextInt(10));
    }

    private static boolean toBool(int number) {
        return number >= RATIO_OVER_TEN;
    }
}
