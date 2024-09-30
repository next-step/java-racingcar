package race.Utils;

import java.util.Random;

public class RandomUtil {
    public static Random random = new Random();

    public static int getValue(int num) {
        return random.nextInt(num);
    }
}
