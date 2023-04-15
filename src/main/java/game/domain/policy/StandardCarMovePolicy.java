package game.domain.policy;

import java.util.concurrent.ThreadLocalRandom;

public class StandardCarMovePolicy implements CarMovePolicy {

    private static final int MOVABLE_THRESHOLD_NUMBER = 4;
    private static final int RANDOM_NUMBER_MINIMUM = 0;
    private static final int RANDOM_NUMBER_MAXIMUM = 9;

    @Override
    public boolean isMovable() {
        return generateRandomNumber() >= MOVABLE_THRESHOLD_NUMBER;
    }

    private int generateRandomNumber() {
        return ThreadLocalRandom
                .current()
                .nextInt(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM + 1);
    }

}