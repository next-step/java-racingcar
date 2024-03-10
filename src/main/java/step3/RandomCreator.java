package step3;

import java.util.Random;

public class RandomCreator implements RandomNumberCreator {

    private static final Random random = new Random();
    private static final int LIMIT_NUMBER = 10;

    @Override
    public int getRandomNumber() {
        return random.nextInt(LIMIT_NUMBER);
    }
}
