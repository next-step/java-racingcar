package study.util;

import java.util.Random;

public class RandomNumberUtil {
    
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);
    }

}
