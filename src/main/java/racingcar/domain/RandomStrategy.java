package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final int BOUND = 10;

    @Override
    public int getNumber() {
        return new Random().nextInt(BOUND);
    }
}
