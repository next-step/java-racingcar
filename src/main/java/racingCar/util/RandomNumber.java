package racingCar.util;

import java.util.Random;

public class RandomNumber {

    private static Random random = new Random();

    private RandomNumber() {}

    public static int getRandomNumber(int bound) {
        return random.nextInt(bound);
    }

}
