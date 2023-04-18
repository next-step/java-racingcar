package racingcar;

import java.util.concurrent.ThreadLocalRandom;

public class FourOverTenMoveStrategy implements MoveStrategy {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int RATIO_OVER_TEN = 4;

    public boolean isMovable() {
        return toBool(RANDOM.nextInt(10));
    }

    private static boolean toBool(int number) {
        return number >= RATIO_OVER_TEN;
    }
}
