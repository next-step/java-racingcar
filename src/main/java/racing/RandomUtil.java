package racing;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static int generateRandomNumberZeroTo(int range) {
        return RANDOM.nextInt(range);
    }
}
