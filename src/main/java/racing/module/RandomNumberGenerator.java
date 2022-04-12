package racing.module;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private final Random RANDOM = new Random();

    @Override
    int getNumber(int boundary) {
        return RANDOM.nextInt(boundary);
    }
}
