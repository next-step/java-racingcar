package step3.gameobject.rule;

import java.util.Random;

public class DefaultRaceRule implements RaceRule {
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean race() {
        return new Random().nextInt(RANDOM_BOUND) >= THRESHOLD;
    }
}
