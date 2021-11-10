package racing;

import java.util.Random;

/**
 * @author han
 */
public class NumberHelper {
    private static Random r = new Random();

    private NumberHelper() {
    }

    public static int getRandomValue(int input) {
        return r.nextInt(input);
    }

    public static int getRandomValue(Random random, int input) {
        return random.nextInt(input);
    }

    public static boolean isLessThanOne(int input) {
        return input < 1;
    }
}
