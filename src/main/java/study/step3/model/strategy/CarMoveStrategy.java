package study.step3.model.strategy;

public class CarMoveStrategy implements MoveStrategy {

    private static final int CAR_MOVE_CONDITION = 4;

    @Override
    public boolean isMoveCondition(int randomNumber) {
        return (randomNumber >= CAR_MOVE_CONDITION);
    }
}