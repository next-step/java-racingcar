package helper;

import java.util.Random;

public class RandomHelper {

    public static Random random = new Random();

    private RandomHelper() {

    }

    public static int makeRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
