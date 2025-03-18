package utils;

import java.util.Random;

public class RandomUtils {

    private Random random;

    public RandomUtils(Random random) {
        this.random = random;
    }

    public int getRandomNumber(int maxRandomNumber) {
        return random.nextInt(maxRandomNumber);
    }

}
