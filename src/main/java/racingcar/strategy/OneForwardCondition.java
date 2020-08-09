package racingcar.strategy;

import static racingcar.Constants.*;

import java.util.Random;

public class OneForwardCondition implements RaceCondition {
        Random random = new Random();
        //Predicate<Integer> not reusable

    @Override
    public boolean pass() {
        return FORWARD_OK_COND_NUM <= random.nextInt(RANDOM_BOUND);
    }
}