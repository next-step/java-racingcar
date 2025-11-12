package racingcar.random;

import java.util.Random;
import racingcar.domain.RandomNumber;

public class SimpleRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random;

    private static final int MAX_VALUE = 10;

    public SimpleRandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public RandomNumber generate() {
        return new RandomNumber(random.nextInt(MAX_VALUE));
    }
}
