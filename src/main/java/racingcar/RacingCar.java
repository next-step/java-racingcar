package racingcar;

public class RacingCar {
    private static final int NUMBER_MOVING_STANDARD = 4;
    private int position;

    public int move(IMovingStrategy iMovingStrategy) {
        if (iMovingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }
}
