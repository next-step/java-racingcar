package carracing.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();

    public int generateZeroOrPositiveNumber(int maxNumber) {
        return RANDOM.nextInt(maxNumber + 1);
    }
}
