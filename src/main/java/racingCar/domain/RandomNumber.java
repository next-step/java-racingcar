package racingCar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_MAX_NUM = 10;
    private final Random random;


    public RandomNumber() {
        this.random = new Random();
    }

    public int getRandomNum() {
        return random.nextInt(RANDOM_MAX_NUM);
    }
}
