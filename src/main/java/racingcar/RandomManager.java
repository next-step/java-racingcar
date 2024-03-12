package racingcar;

import java.util.Random;

public class RandomManager {
    private static final int RANDOM_VALUE = 10;
    private static final Random random = new Random();
    private static RandomManager instance = new RandomManager();

    private RandomManager() {

    }

    public static RandomManager getInstance() {
        return instance;
    }

    public int getRandomValue() {
        int randomValue = random.nextInt(RANDOM_VALUE);
        return randomValue;
    }

}
