package racingcar.domain;

public class CarPosition {

    private int currentPosition;

    public CarPosition(int position) {
        this.currentPosition = position;
    }

    public void move() {
        currentPosition++;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
