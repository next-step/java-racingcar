package car.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int randomNumber() {
        return random.nextInt(10);
    }

}
