package racingcar.engine;

import racingcar.common.ErrorMessage;

public class CarEngine extends Engine {

    private final int OPERATE_FLAG = 4;
    private final int MOVE_DISTANCE = 1;

    @Override
    public int operate(int input) {
        if (!inputValidatation(input)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }

        return (input >= OPERATE_FLAG) ? MOVE_DISTANCE : 0;
    }

    public boolean inputValidatation(int input) {
        return (input >= MIN_INPUT && input <= MAX_INPUT);
    }
}
