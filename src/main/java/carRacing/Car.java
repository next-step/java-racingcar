package carRacing;

import java.util.Random;

public class Car {
    private static final int MAX_BOUNDS = 10;
    private static final int MOVE_STANDARD = 4;

    private int position;

    private boolean isMove(Random random) {
        return random.nextInt(MAX_BOUNDS) >= MOVE_STANDARD;
    }

    int go(Random random) {
        return isMove(random) ? ++position : position;
    }
}
