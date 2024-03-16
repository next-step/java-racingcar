package racingcar.domain.movement;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final int RANDOM_NUMBER_MAX_LIMIT = 10;

    @Override
    public int generate() {
        return random.nextInt(RANDOM_NUMBER_MAX_LIMIT);
    }
}
