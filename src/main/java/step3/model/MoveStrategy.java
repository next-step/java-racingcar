package step3.model;

import java.util.Random;

public class MoveStrategy {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_MAX_NUMBER = 10;

    public int generateNumber() {
        return RANDOM.nextInt(RANDOM_MAX_NUMBER);
    }
}
