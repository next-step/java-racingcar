package racing.util;

import java.util.Random;

public class RandomInt {

    private static final int RANDOM_INT_MAX = 8;
    private static final int RANDOM_INT_MIN = 1;

    public static int makeRandomInt(){
        Random random = new Random();
        int randomPower = random.nextInt(RANDOM_INT_MAX) + RANDOM_INT_MIN;
        return randomPower;
    }
}
