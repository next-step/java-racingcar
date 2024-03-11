package game.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final Random random = new Random();

    @Override
    public int getNumbers(int bound) {
        return random.nextInt(bound);
    }
}
