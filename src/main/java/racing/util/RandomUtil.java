package racing.util;

import java.util.Random;

public class RandomUtil {

    private static final int BOUND = 10;
    public static Random random = new Random();

    public static int random(){
        return random.nextInt(BOUND);
    }
}
