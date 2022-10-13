package step3_pobi.domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {

    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return getRandom() >= FORWARD_NUM;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
