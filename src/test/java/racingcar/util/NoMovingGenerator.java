package racingcar.util;

import static racingcar.model.Car.RUNNING_CONDITION;

public class NoMovingGenerator implements NumberGenerator{
    @Override
    public int getNumber() {
        return RUNNING_CONDITION-1;
    }
}
