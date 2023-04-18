package study.racingcar;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;
    @Override
    public boolean isMove() {
        return GenerateNumber.random() >= MOVE_CONDITION;
    }
}
