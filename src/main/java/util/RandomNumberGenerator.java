package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX_BOUND);
    }
}
