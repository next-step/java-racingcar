package carracing.util;

import java.util.Random;

public class RandomCondition {
    private static final int RANDOM_RANGE = 10;     /* 랜덤 주행 조건 범위 0 ~ 9 */

    private static final Random random = new Random();

    public static int getCondition() {
        return random.nextInt(RANDOM_RANGE);
    }
}
