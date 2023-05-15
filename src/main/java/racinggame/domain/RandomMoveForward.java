package racinggame.domain;

import racinggame.domain.MoveStrategy;

import java.util.Random;

public class RandomMoveForward implements MoveStrategy {
    private static final int RANDOM_NUMBER_STANDARD = 10;
    private static final int MOVE_STANDARD = 4;
    private static final Random DEFAULT_RANDOM = new Random();

    public static int randomNumber() {
        return DEFAULT_RANDOM.nextInt(RANDOM_NUMBER_STANDARD);
    }

    @Override
    public boolean movable() {
        return randomNumber() >= MOVE_STANDARD;
    }
    
}
