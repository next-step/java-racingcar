package racingcar;

import java.util.Random;

public class BoundaryRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate(int boundary) {
        return random.nextInt(boundary);
    }
}
