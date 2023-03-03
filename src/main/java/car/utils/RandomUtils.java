package car.utils;

import java.util.Random;

public class RandomUtils {

    public static int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
