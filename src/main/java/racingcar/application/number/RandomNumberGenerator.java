package racingcar.application.number;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int getNumber() {
        final int RANDOM_NUMBER_BOUND = 10;
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

}
