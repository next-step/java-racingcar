package racingcar;

public class Car {

    public static final int MOVE_CONDITION = 4;
    private int currentPosition;

    public int moveCar(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            currentPosition++;
        }
        return currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void forceMove() {
        currentPosition++;
    }
}
