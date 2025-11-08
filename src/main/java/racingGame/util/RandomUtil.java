package racingGame.util;

import java.util.Random;

public class RandomUtil {
    
    public static final int RANDOM_BOUND = 10;
    
    public static int generateInt() {
        return getRandom().nextInt(RANDOM_BOUND);
    }
    
    private static Random getRandom() {
        return new Random();
    }
    
}
