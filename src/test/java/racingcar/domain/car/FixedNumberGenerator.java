package racingcar.domain.car;

import racingcar.domain.car.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {
    private static final int MOVE_CONDITION_NUMBER = 4;

    @Override
    public int generateNumber() {
        return MOVE_CONDITION_NUMBER;
    }
}
