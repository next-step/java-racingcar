package step3.game;

import java.util.Random;

public class RandomGenerator {

    public static final Random RANDOM = new Random();
    public static final int BOUND = 10;

    public static int getRandomValue() {
        return RANDOM.nextInt(BOUND);
    }
}
