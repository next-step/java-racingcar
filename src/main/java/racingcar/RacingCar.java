package racingcar;

import java.util.Random;

public class RacingCar {
    private static final int MOVE_CONDITION = 4;
    private static final int MOVE_UNIT = 1;
    private int position;

    RacingCar() {
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
