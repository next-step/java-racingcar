package racingcar.domain;

import java.util.Random;

public class RacingRandom {
    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    private static final Random random = new Random();

    public boolean isMove() {
        int randomNumber = random.nextInt(RANDOM_NUMBER);
        return randomNumber >= MOVABLE_NUMBER;
    }

}
