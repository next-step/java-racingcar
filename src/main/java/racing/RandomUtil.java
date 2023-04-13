package racing;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();
    public static final int CORRECTION_VALUE = 1;

    private RandomUtil() {
    }
    
    public static int generateRandomNumberZeroTo(int range) {
        return RANDOM.nextInt(range + CORRECTION_VALUE);
    }

}
