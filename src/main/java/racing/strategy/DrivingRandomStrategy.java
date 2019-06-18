package racing.strategy;

import java.util.Random;

public class DrivingRandomStrategy implements DrivingStrategy {
    static public int MAX_RANDOM_NUMBER = 10;
    public static int MIN_MOVABLE_NUMBER = 4;

    private Random mRandom;

    public DrivingRandomStrategy() {
        mRandom = new Random();
    }

    @Override
    public boolean isMovable() {
        int rand = getNumber();
        return rand >= MIN_MOVABLE_NUMBER;
    }

    private int getNumber() {
        return mRandom.nextInt(MAX_RANDOM_NUMBER);
    }
}
