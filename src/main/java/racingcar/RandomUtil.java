package racingcar;

import java.util.Random;

public class RandomUtil {

    public static final int RANDOM_RANGE = 10;

    public int generateRandomNum() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
