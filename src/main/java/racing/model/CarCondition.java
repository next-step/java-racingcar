package racing.model;

import java.util.Random;

public class CarCondition {

    private static final int CONDITION_BOUND = 10;
    private static Random random = new Random();

    public static int get() {
        return random.nextInt(CONDITION_BOUND);
    }
}
