package racingcar.util;

import static racingcar.model.Car.RUNNING_CONDITION;

public class MovingGenerator implements NumberGenerator{
    @Override
    public int getNumber() {
        return RUNNING_CONDITION;
    }
}
