package racingcar;

import java.util.Random;

public class RandomUtil {

    public static int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
