package racingcar.domain.movingcondition;

import java.util.Random;

public class RandomMovingCondition implements MovingCondition {

    private final int RANDOM_MAGIC_NUMBER  = 10;

    public boolean canMove() {
        return generateRandomIntValue() >= 4;
    }

    private int generateRandomIntValue() {
        return new Random().nextInt(10);
    }
}
