package racing.util;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    @Override
    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}
