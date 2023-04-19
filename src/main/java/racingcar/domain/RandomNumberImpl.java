package racingcar.domain;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber {
    private static Random random = new Random();

    @Override
    public int getInt() {
        return random.nextInt(UPPER_BOUND);
    }

}
