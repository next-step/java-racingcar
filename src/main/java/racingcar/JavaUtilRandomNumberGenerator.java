package racingcar;

import java.util.Random;

public class JavaUtilRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate(int max) {
        return random.nextInt(max);
    }
}
