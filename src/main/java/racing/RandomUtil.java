package racing;

import java.util.Random;

public class RandomUtil {
    public static int randomNumberZeroToNine() {
        return new Random().nextInt(10);
    }
}
