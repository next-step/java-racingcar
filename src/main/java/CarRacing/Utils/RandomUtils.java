package CarRacing.Utils;

import java.util.Random;

public class RandomUtils {
    static final int RANDOM_NUMBER_SIZE = 10;

    public static int generateRandom() {
        return new Random().nextInt(RANDOM_NUMBER_SIZE);
    }
}
