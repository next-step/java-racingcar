package racing;

import java.util.Random;

public class RandomGenerator {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_MAX_VALUE = 10;

    public static int getNumber(){
        return RANDOM.nextInt(RANDOM_MAX_VALUE);
    }
}
