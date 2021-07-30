package racingcargame;

import java.util.Random;

public class RandomNumberOption implements RandomOption {
    private final Random random = new Random();

    @Override
    public int randomValue() {
        return random.nextInt(10);
    }
}
