package racingcarwinner.domain;

import java.util.Random;

public class RandomNumber implements MovableStrategy {

    private static final int BOUND = 10;
    private static final int MOVABLE_STANDARD = 4;

    @Override
    public boolean isPossibleToMove() {
        return new Random().nextInt(BOUND) >= MOVABLE_STANDARD;
    }
}
