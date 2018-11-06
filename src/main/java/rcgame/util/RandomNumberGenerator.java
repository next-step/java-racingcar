package rcgame.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int RANDOM_BOUND_NUMBER = 10;

    public int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }
}