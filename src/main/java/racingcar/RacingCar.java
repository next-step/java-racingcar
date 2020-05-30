package racingcar;

public class RacingCar {
    private int position;

    public int move(IMovingStrategy iMovingStrategy) {
        if (iMovingStrategy.isMove()) {
            return ++position;
        }
        return position;
    }
}
