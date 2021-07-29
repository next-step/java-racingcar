package util;

import java.util.Random;

public class RandomNumUtil {

    private static Random random = new Random();

    public static int makeRandomNumber() {
        return random.nextInt(10);
    }

}
