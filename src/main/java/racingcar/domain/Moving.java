package racingcar.domain;

import java.util.Random;

public enum Moving {
    GO, STOP;

    private static final int MIN_MOVING_VALUE = 4;
    private static final int MAX_MOVING_VALUE = 10;
    private static final Random RANDOM = new Random();

    public static Moving create() {
        if (RANDOM.nextInt(MAX_MOVING_VALUE) >= MIN_MOVING_VALUE) {
            return GO;
        }
        return STOP;
    }
}
