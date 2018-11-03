package racing.util;

import java.util.Random;

public class DefaultRandomNumberProvider implements RandomNumberProvider {

    private static final Random RANDOM = new Random();

    @Override
    public int getRandomNumber() {
        return RANDOM.nextInt(10);
    }
}
