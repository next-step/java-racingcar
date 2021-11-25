package carracing;

import java.util.Random;

public class RandomFactory {

    private RandomFactory() {}

    private static final Random random = new Random();

    public static int generate(int bound) {
        return random.nextInt(bound);
    }
}
