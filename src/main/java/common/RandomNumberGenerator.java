package common;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private final int RANGE = 10;
    private final Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(RANGE);
    }
}

