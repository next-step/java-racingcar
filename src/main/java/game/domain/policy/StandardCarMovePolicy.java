package game.domain.policy;

import java.util.concurrent.ThreadLocalRandom;

public class StandardCarMovePolicy implements CarMovePolicy {

    @Override
    public boolean isMovable() {
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return ThreadLocalRandom
                .current()
                .nextInt(0, 10 + 1);
    }
    
}