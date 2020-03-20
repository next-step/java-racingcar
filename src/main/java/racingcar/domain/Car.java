package racingcar.domain;

import java.util.Random;

public class Car {
    private final int RANDOM_BOUND = 10;
    private final int ADVANCE_CONDITION = 4;

    private int position;

    public int move() {
        if (advance()) {
            this.position++;
        }

        return position;
    }

    private boolean advance() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND) > ADVANCE_CONDITION;
    }
}
