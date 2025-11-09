package racingcar;

import java.util.Random;

public class SimpleRandomNumber implements RandomNumber {
    private final Random random;

    private static final int MAX_VALUE = 10;

    public SimpleRandomNumber() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(MAX_VALUE);
    }
}
