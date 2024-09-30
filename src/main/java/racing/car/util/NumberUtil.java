package racing.car.util;

import java.util.Random;

public class NumberUtil {

    public static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
