package study.racingcar;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;
    @Override
    public boolean isMove(int number) {
        return number >= MOVE_CONDITION;
    }
}
