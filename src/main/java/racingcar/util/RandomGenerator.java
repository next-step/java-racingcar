package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public int generator() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
