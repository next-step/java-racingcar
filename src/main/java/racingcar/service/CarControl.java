package racingcar.service;

import java.util.Random;

public class CarControl {
    private final Random RANDOM = new Random();
    private final int BOUND = 10;

    private final boolean GO = true;
    private final boolean STOP = false;

    public boolean goOrStop() {
        if (random() > 4) {
            return GO;
        }
        return STOP;
    }

    private int random() {
        return RANDOM.nextInt(BOUND);
    }
}
