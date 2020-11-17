package domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomRacingCarMovingRule implements RacingCarMovingRule {

    @Override
    public boolean shouldForward() {
        // XXX double_random <= chance is much better
        return ThreadLocalRandom.current().nextInt(10) >= 4;
    }

}
