package racingcar;

import java.util.Random;

public class RandomNumber {

    private static final int BOUND_NUMBER = 10;
    private int randomNumber = 0;

    public RandomNumber() {
        this.randomNumber = randomNumberExtraction();
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static int randomNumberExtraction() {
        Random random = new Random();
        return random.nextInt(BOUND_NUMBER);
    }
}
