package util;

import java.util.Random;

public class RacingCarUtil {

    public static int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
