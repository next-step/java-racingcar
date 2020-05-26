package study.nextstep.stage4;

import java.util.Random;

public class Position {
    private static final int THRESHOLD_CAR_MOVE_RANDOM_VAL = 4;
    private static final int CAR_MOVE_RANDOM_LIMIT_VAL = 10;

    private int position;

    public Position() {
        position = 1;
    }

    public void run(Random randomModule) {
        if (randomModule.nextInt(CAR_MOVE_RANDOM_LIMIT_VAL) >= THRESHOLD_CAR_MOVE_RANDOM_VAL) {
            position++;
        }
    }

    public int getValue() {
        return position;
    }
}
