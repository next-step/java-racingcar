package car.utils;

import java.util.Random;

public class RandomUtils {

    public static int generateRandomValueBy(int condVal) {
        Random random = new Random();
        return random.nextInt(condVal);
    }
}
