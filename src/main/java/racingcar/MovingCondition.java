package racingcar;

import java.util.Random;

public class MovingCondition {
    private static final int RANDOMNUMBER = 4;

    public boolean isMovable() {
        return new Random().nextInt(10) >= RANDOMNUMBER;
    }

}
