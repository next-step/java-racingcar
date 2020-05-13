package racingcar.domain.car;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public int generateNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }
}
