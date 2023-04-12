package racingcar;

public class RacingCar {
    public static final int CAR_MOVE_STANDARD = 4;

    public boolean moveYn(int randomNumber) {
        return randomNumber >= CAR_MOVE_STANDARD;
    }
}
