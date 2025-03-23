package racingcar.domain.movingstrategy;

import java.util.Random;

public class RandomStrategy implements MovingStrategy{

    public static final int BOUND = 10;
    public static final int MOVABLE_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(BOUND) >= MOVABLE_THRESHOLD;
    }
}
