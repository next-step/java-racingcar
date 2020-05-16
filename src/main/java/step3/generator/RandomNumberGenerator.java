package step3.generator;

import java.util.Random;

public class RandomNumberGenerator implements GenerateNumberStrategy {

    private static final int BOUNDARY = 10;
    private static final int MOVABLE_NUMBER = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMove() {
        return RANDOM.nextInt(BOUNDARY) >= MOVABLE_NUMBER;
    }
}
