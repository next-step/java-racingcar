package racingcar.domain.status;

public class CarMoveAbility implements MoveAbility {
    private static final int MOVE_CONDITION_SIZE = 4;

    @Override
    public boolean hasMoveAbility(int number) {
        return MOVE_CONDITION_SIZE <= number;
    }
}
