package step3;

import java.util.concurrent.ThreadLocalRandom;

public class RacingCarForwardMatcher implements GameMatcher {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int RANDOM_BOUND = 10;
    public static final int CAR_FORWARD_MINIMUM_NUMBER = 4;

    @Override
    public boolean matcher() {
        return RANDOM.nextInt(RANDOM_BOUND) >= CAR_FORWARD_MINIMUM_NUMBER;
    }
}
