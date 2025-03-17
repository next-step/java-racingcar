package utils;

import java.util.Random;

public class RandomUtils {

    private static final Random rand = new Random();

    public static int getRandomNumber(int maxRandomNumber) {
        return rand.nextInt(maxRandomNumber);
    }

}
