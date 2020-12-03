package step3;

import java.util.Random;

public class RandomGenerator {

    private final static Random random = new Random();

    public static int generate() {
        return random.nextInt(10);
    }
}
