package racing.module;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private static final int RANDOM_BOUNDARY_NUMBER = 10;
    private final Random RANDOM = new Random();

    @Override
    int getNumber(int boundary) {
        return RANDOM.nextInt(RANDOM_BOUNDARY_NUMBER);
    }
}
