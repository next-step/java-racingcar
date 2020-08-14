package racingcar.utils;

import racingcar.constant.Constant;

import java.util.Random;

public class CarMove implements Move{


    @Override
    public boolean moveAble() {
        return new Random()
                .nextInt(Constant.LIMIT_RANDOM_VALUE) >= Constant.MOVEABLE_REFERENCE_VALUE;
    }
}
