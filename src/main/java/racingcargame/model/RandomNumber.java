package racingcargame.model;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();

    public static int createRandomNumber() {
        return random.nextInt(10);
    }
}
