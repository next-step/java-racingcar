package racingCar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int MAX_RANDOM_NUMBER = 9;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) + 1;
    }
}
