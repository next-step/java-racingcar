package racingcar.domain;

import java.util.Random;

public class RacingCar {
    private static final int MOVE_CONDITION = 4;
    private static final int MOVE_UNIT = 1;
    private int position;

    public RacingCar() {
        position = 0;
    }

    public int moveOrStop() {
        int r = random();
        if (r >= MOVE_CONDITION) {
            position += MOVE_UNIT;
        }

        return position;
    }

    public static int random() {
        return new Random().nextInt(10);
    }
}
