package racingcar.domain;

import java.util.Random;

public class RacingRandom {
    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    public boolean isMove() {
        Random random = new java.util.Random();
        int random_number = random.nextInt(RANDOM_NUMBER);
        if (random_number >= MOVABLE_NUMBER) {
            return true;
        }
        return false;
    }

}
