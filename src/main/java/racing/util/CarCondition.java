package racing.util;

import java.util.Random;

public class CarCondition {

    private static Random random = new Random();
    private static final int CONDITION_BOUND = 10;

    public static int get() {
        return random.nextInt(CONDITION_BOUND);
    }
}
