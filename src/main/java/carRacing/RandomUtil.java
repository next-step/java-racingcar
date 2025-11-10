package carRacing;

import java.util.Random;

public class RandomUtil {

    public static final Random RANDOM = new Random();
    public static final int MAX_VALUE = 10;

    public static int getRandomValue() {
        return RANDOM.nextInt(MAX_VALUE);
    }
}