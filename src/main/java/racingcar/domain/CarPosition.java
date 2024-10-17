package racingcar.domain;

public class CarPosition {

    private static final int MOVE_CONDITION = 4;
    private int currentPosition;

    public CarPosition(int position) {
        this.currentPosition = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            currentPosition++;
        }
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
