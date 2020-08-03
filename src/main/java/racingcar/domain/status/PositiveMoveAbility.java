package racingcar.domain.status;

public class PositiveMoveAbility implements MoveAbility {
    @Override
    public boolean hasMoveAbility(int number) {
        return true;
    }
}
