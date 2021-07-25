package racingcar;

import java.util.Random;

public class RandomUtil {
    static final int BOUND = 10;

    public int getRandomInt() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
