package step3.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANGE = 10;

    private static Random random = new Random();

    public static int getRandomValue(){
        return random.nextInt(RANGE);
    }
}
