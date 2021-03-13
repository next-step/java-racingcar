package study.step3;

import study.step2.StringValidator;

public class CarMoveByNameLengthStrategy implements MoveStrategy{
    @Override
    public boolean isMove(int condition) {
        return condition == StringValidator.CAR_NAME_LENGTH_MOVE_CONDITION;
    }
}
