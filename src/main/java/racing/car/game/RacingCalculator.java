package racing.car.game;

import racing.car.util.NumberUtil;

public class RacingCalculator {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    public static int getRandomNumber() {
        return NumberUtil.randomInt(MIN_BOUND, MAX_BOUND);
    }

}
