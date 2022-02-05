package racingcar.domain;

public class MovingCar {

    private static final int MOVABLE = 4;

    public boolean isMove(int number) {
        return number >= MOVABLE;
    }
}
