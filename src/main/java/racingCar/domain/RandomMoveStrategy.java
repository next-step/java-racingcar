package racingCar.domain;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int START_CONDITION = 4;
    private static final int END_CONDITION = 9;

    @Override
    public boolean isMove(int value) {
        if(value >= START_CONDITION && value <= END_CONDITION) {
            return true;
        }
        return false;
    }
}
