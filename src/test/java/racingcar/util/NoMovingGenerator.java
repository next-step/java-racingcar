package racingcar.util;

import static racingcar.model.Car.MOVING_CONDITION;

public class NoMovingGenerator implements NumberGenerator{
    @Override
    public int getNumber() {
        return MOVING_CONDITION -1;
    }
}
