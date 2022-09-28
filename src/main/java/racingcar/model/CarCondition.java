package racingcar.model;

import java.util.Random;

public class CarCondition implements Condition {

    private static final Random random = new Random();
    private static final int BOUND = 10;
    private static final int CONDITION = 4;

    public boolean inspect() {
        return random.nextInt(BOUND) > CONDITION;
    }

}
