package game.domain.policy;

import java.util.concurrent.ThreadLocalRandom;

public class StandardCarMovePolicy implements CarMovePolicy {

    private static final int MOVABLE_THRESHOLD_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return generateRandomNumber() >= MOVABLE_THRESHOLD_NUMBER;
    }

    private int generateRandomNumber() {
        return ThreadLocalRandom
                .current()
                .nextInt(0, 10 + 1);
    }

}