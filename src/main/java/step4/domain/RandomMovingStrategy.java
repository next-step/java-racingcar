package step4.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int FORWARD_NUM = 4;
    private static final int RANGE = 10;
    private static final Random random = new Random();
 
    @Override
    public boolean movable() {
        return getRandomNo() >= FORWARD_NUM;
    }

    private int getRandomNo() {
        return random.nextInt(RANGE);
    }

}
