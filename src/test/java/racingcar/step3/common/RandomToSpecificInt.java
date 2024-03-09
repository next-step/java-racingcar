package racingcar.step3.common;

import java.util.Random;

public class RandomToSpecificInt extends Random {

    private final int specificValue;

    public RandomToSpecificInt(int specificValue) {
        super(0L);
        this.specificValue = specificValue;
    }

    @Override
    public int nextInt(int bound) {
        return specificValue;
    }
}
