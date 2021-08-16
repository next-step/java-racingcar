package racingcargame.model;

import java.util.Random;

public class RandomNumber {
    private static final int EXCEED_NUMBER = 10;
    private static final Random random = new Random();

    public static int createRandomNumber() {
        return random.nextInt(EXCEED_NUMBER);
    }
}