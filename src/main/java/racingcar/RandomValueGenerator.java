package racingcar;

import java.util.Random;

public class RandomValueGenerator implements Generator {
    public static final Random random = new Random(System.currentTimeMillis());

    public int nextValue() {
        return random.nextInt(9);
    }
}
