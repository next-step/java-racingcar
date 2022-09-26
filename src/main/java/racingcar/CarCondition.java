package racingcar;

import java.util.Random;

public class CarCondition implements Condition{

    private static final Random random = new Random();

    public boolean inspect() {
        return random.nextInt(10) > 4;
    }

}
