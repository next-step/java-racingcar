package racingcar.domain;

import java.util.Random;

public class CarCondition implements Condition {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int CONDITION = 4;

    public boolean inspect() {
        return RANDOM.nextInt(BOUND) >= CONDITION;
    }
}
