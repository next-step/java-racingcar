package racingcar.domain;

import java.util.Random;

public class RacingRandom {
    private static final int RACING_NUMBER = 10;
    private static final int MOVABLE_CONDITION = 4;

    private static final Random random = new Random();

    public boolean isMove() {
        int randomNumber = random.nextInt(RACING_NUMBER);
        return randomNumber >= MOVABLE_CONDITION;
    }

}
