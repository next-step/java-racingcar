package racingcar.domain;

public class MovingStrategy {
    public static final int CAN_MOVE_RANGE = 4;

    public boolean movable(int randomNumber) {
        return randomNumber >= CAN_MOVE_RANGE;
    }
}
