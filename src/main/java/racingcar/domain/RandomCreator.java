package racingcar.domain;

import java.util.Random;

public class RandomCreator {
    private static final int RANGE = 10;

    public int createNewPosition() {
        return new Random().nextInt(RANGE);
    }
}
