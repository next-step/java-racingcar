package step5;

import java.util.Random;

public class RandomMoveDeterminator {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public static boolean doMoving() {
        return RANDOM.nextInt(BOUND) > 3;
    }

}
