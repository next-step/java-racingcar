package racingcar.domain;

import java.util.Random;

public enum Moving {
    GO, STOP;

    private static final Random random = new Random();

    public static Moving create() {
        if (random.nextInt(10) >= 4) {
            return GO;
        }
        return STOP;
    }
}
