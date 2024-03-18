package step5.domain.car.move.random;

import java.util.Random;

public class RandomCreator implements RandomNumberCreator {

    private static final Random RANDOM = new Random();
    private static final int LIMIT_NUMBER = 10;

    @Override
    public int getRandomNumber() {
        return RANDOM.nextInt(LIMIT_NUMBER);
    }
}
