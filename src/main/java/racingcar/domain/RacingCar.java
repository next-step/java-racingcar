package racingcar.domain;

public class RacingCar {
    private static final int NUMBER_MOVING_STANDARD = 4;
    private int position;

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= NUMBER_MOVING_STANDARD;
    }

    public int getPosition() {
        return position;
    }
}
