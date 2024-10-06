package racingcar.domain;

import java.util.Random;

public class RandomMove implements MovingStrategy {
    public static final int NUMBER_BOUND = 10;
    public static final int MOVE_MIN = 4;
    public static final Random RANDOM = new Random();
    private static RandomMove INSTANCE = null;

    public static RandomMove getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RandomMove();
        }
        return INSTANCE;
    }

    @Override
    public boolean movable() {
        return movable(getRandomValue());

    }

    public int getRandomValue() {
        return RANDOM.nextInt(NUMBER_BOUND);
    }

    public boolean movable(int randomValue){
        return randomValue >= MOVE_MIN;
    }
}
