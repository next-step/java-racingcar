package study.racing4;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int BASE_NUM = 4;
    private final Random random = new Random();

    @Override
    public boolean moveable() {
        return getRandomNumber() > BASE_NUM;
    }

    private int getRandomNumber() {
        return random.nextInt(10);
    }
}
