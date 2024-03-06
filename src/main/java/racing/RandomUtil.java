package racing;

import java.util.Random;

public class RandomUtil {

    public static final int BOUND = 10;

    public static int randomNumberZeroToNine() {
        return new Random().nextInt(BOUND);
    }
}
