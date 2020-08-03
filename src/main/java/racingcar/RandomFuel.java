package racingcar;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomFuel implements Fuel {

    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    @Override
    public int getAsInt() {
        return random.nextInt(RANDOM_RANGE);
    }
}
