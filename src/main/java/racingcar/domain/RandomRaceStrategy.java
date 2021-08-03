package racingcar.domain;

import java.util.Random;

public class RandomRaceStrategy implements RaceStrategy {
    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final Random random = new Random();

    @Override
    public boolean decideToMove() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
