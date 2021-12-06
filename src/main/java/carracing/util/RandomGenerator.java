package carracing.util;

import java.util.Random;

public class RandomGenerator {
    private final Random random = new Random();

    public int generateZeroOrPositiveNumber(int maxNumber) {
        return random.nextInt(maxNumber + 1);
    }
}
