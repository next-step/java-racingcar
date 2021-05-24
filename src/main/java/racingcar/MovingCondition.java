package racingcar;

import java.util.Random;

public class MovingCondition {
    public static final int RANDOMNUMBER = 4;

    public MovingCondition() {

    }

    public boolean isMovable() {
        return new Random().nextInt(10) >= RANDOMNUMBER;
    }

}
