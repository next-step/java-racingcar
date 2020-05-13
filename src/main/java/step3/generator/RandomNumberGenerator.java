package step3.generator;

import java.util.Random;

public class RandomNumberGenerator implements GenerateNumberStrategy {

    private static final int BOUNDARY = 10;
    private static final Random RANDOM = new Random();

    @Override
    public int generateNumber() {
        return RANDOM.nextInt(BOUNDARY);
    }
}
