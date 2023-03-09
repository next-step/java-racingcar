package car.utils;

import java.util.Random;

public class RandomUtils {

    public static int getRandomValueLesserThen(int value) {
        Random random = new Random();
        return random.nextInt(value);
    }
}
