package racingcar;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomNumberGenerator implements IntSupplier {

    private static final int BOUND = 10;

    private final Random random = new Random();

    @Override
    public int getAsInt() {
        return random.nextInt(BOUND);
    }
}