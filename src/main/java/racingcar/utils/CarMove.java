package racingcar.utils;

import java.util.Random;

public class CarMove implements Move{
    private static final int LIMIT_RANDOM_VALUE = 10;
    private static final int MOVEABLE_REFERENCE_VALUE = 4;

    @Override
    public boolean moveAble() {
        return new Random().nextInt(LIMIT_RANDOM_VALUE) >= MOVEABLE_REFERENCE_VALUE;
    }
}
