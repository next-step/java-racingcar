package racingversion2.car.util;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random RANDOM = new Random();

    public static int generateRandomValue() {
        return RANDOM.nextInt(10);
    }

}
