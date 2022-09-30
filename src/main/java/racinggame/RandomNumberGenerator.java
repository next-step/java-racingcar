package racinggame;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BOUND_NUMBER = 10;

    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(BOUND_NUMBER);
    }

}
