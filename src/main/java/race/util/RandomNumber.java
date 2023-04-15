package race.util;

import java.util.Random;

public class RandomNumber {


    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    private RandomNumber(){}

    public static int get() {
        return RANDOM.nextInt(BOUND);
    }
}
