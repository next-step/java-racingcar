package study.step5.utils;

import java.util.Random;

public class CommonUtil {
    private static final int RANDOM_RANGE = 10;
    private static final Random RANDOM = new Random();
    public static final String POSITION_CHARTER = "-";

    public static int getRandomInt() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
