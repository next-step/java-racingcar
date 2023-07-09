package car.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int NUMBER_LIMIT = 10;

    public int createCarSpeed() {
        return new Random().nextInt(NUMBER_LIMIT);
    }
}
