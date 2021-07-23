package racingcar.domain.engine;

import racingcar.common.exception.InvalidCarEngineOperateInputException;

public class CarEngine extends Engine {

    private static final int OPERATE_FLAG = 4;
    private static final int MOVE_DISTANCE = 1;

    @Override
    public int operate(int input) {
        if (!inputValidatation(input)) {
            throw new InvalidCarEngineOperateInputException();
        }

        if (input >= OPERATE_FLAG) {
            return MOVE_DISTANCE;
        }

        return 0;
    }

    private boolean inputValidatation(int input) {
        if (input >= Engine.MIN_INPUT && input <= Engine.MAX_INPUT) {
            return true;
        }

        return false;
    }
}
