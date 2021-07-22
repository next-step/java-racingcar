package racingcar.common;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static Integer nextInt(int num) {
        return RANDOM.nextInt(num);
    }
}
