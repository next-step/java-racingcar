package racingcar;

import java.util.Random;

public class RandomManaager {
    private static final int RANDOM_VALUE = 10;
    private static final Random random = new Random();
    private static RandomManaager instance = new RandomManaager();

    private RandomManaager() {

    }

    public static RandomManaager getInstance() {
        return instance;
    }

    public int getRandomValue() {
        int randomValue = random.nextInt(RANDOM_VALUE);
        return randomValue;
    }

}
