package racingcar.util;

import static racingcar.model.Car.MOVING_CONDITION;

public class MovingGenerator implements NumberGenerator{
    @Override
    public int getNumber() {
        return MOVING_CONDITION;
    }
}
