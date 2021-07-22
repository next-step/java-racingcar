package racingcar.engine;

import racingcar.common.ErrorMessage;

public class CarEngine extends Engine {

    private final int operateFlag = 4;
    private final int moveDistance = 1;

    @Override
    public int operate(int input) {
        if (!inputValidatation(input)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }

        if (input >= operateFlag) {
            return moveDistance;
        }

        return 0;
    }

    private boolean inputValidatation(int input) {
        if (input >= minInput && input <= maxInput) {
            return true;
        }

        return false;
    }
}
