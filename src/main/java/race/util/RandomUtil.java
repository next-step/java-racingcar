package race.util;

import java.util.Random;

public class RandomUtil {
    private static final int BOUND = 10;

    public int randomNum() {
        return new Random().nextInt(BOUND);
    }
}
