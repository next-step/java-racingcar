package step4;

import java.util.Random;

public class RandomMoveDeterminator {
    private static final Random RANDOM = new Random();

    public static boolean doMoving() {
        return RANDOM.nextInt(10) > 3;
    }

}
