package racingcar.domain;

import java.util.Random;

public class DefaultRandomPicker implements RandomPicker {

    private static final int RANDOM_BOUND = 10; // random number range => 0 ~ 9

    @Override
    public GameNumber pickNumber() {
        Random random = new Random();

        return GameNumber.newNumber(random.nextInt(RANDOM_BOUND));
    }
}
