package util;

import java.util.Random;

public class CommonUtil {

    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);
    }
}