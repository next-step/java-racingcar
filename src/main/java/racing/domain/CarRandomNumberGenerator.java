package racing.domain;

import java.util.Random;

public class CarRandomNumberGenerator implements RandomNumberGenerator {
    private static final int MAX_BOUNDED = 10;
    private Random random = new Random();

    @Override
    public int getRandomNum() {
        return random.nextInt(MAX_BOUNDED);
    }
}
