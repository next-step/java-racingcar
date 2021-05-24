package racingcar.domain;

import java.util.Random;

public class RacingRandom {
    private Random random = new Random();

    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    public boolean isMove() {
        int randomNumber = random.nextInt(RANDOM_NUMBER);
        return randomNumber >= MOVABLE_NUMBER;
    }

}
