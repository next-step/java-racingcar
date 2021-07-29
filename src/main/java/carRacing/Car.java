package carRacing;

import java.util.Random;

public class Car {
    private int position;

    private boolean isMove(Random random) {
        return random.nextInt(10) >= 4;
    }

    int go(Random random) {
        return isMove(random) ? ++position : position;
    }
}
