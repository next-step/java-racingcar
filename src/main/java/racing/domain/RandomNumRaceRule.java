package racing.domain;

import racing.RaceRule;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumRaceRule implements RaceRule {

    private final static int RANDOM_NUMBER_BOUND = 10;
    private final static int MIN_NUM_OF_FORWARD = 4;

    public boolean isForward() {
        return ThreadLocalRandom.current().nextInt(RANDOM_NUMBER_BOUND) >= MIN_NUM_OF_FORWARD;
    }
}
