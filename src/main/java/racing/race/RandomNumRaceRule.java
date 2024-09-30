package racing.race;

import racing.RaceRule;

import java.util.Random;

public class RandomNumRaceRule implements RaceRule {

    private final static int RANDOM_NUMBER_BOUND = 10;
    private final static int MIN_NUM_OF_FORWARD = 4;

    private final static Random RANDOM = new Random();

    public boolean isForward() {
        RANDOM.setSeed(System.currentTimeMillis());
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND) >= MIN_NUM_OF_FORWARD;
    }
}
