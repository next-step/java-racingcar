package racingcar;

public class RacingCar {
    public static final int CAR_MOVE_STANDARD = 4;
    public static final int BEGIN_INDEX = 0;
    public static final char CAR_MOVE_STATE = '-';

    public boolean moveYn(int randomNumber) {
        return randomNumber >= CAR_MOVE_STANDARD;
    }

    public String makeCarMoveStateLine(int moveCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = BEGIN_INDEX; i < moveCount; i++) {
            sb.append(CAR_MOVE_STATE);
        }
        return sb.toString();
    }
}
