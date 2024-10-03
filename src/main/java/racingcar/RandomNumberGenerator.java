package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int MAXIMUM_BOUNDARY_NUMBER = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(MAXIMUM_BOUNDARY_NUMBER);
    }
}
