package step3.domain.movingstrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVING_THRESHOLD = 4;
    @Override
    public Boolean run() {
        int value = new Random().nextInt(MAX_RANDOM_NUMBER);
        return value >= MOVING_THRESHOLD;
    }
}
