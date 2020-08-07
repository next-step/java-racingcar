package racingcar.domain.status;

import racingcar.util.RandomGenerator;

public class CarMoveAbility implements MoveAbility {
    private static final int MOVE_CONDITION_SIZE = 4;

    @Override
    public boolean hasMoveAbility() {
        return MOVE_CONDITION_SIZE <= RandomGenerator.getNumber();
    }
}
