package racing;

import java.util.Random;

/**
 * @author han
 */
public class NumberHelper {
    private static Random random = new Random();

    public static int getRandomValue(int input) {
        return random.nextInt(input);
    }
}
