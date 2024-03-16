package racingcar.domain.movement;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int RANDOM_NUMBER_MINIMUM = 0;
    public static final int RANDOM_NUMBER_MAXIMUM = 9;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM + 1);
    }
}
