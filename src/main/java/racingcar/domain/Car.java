package racingcar.domain;

public class Car {
    private final static int MOVE_CONDITION = 4;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber > MOVE_CONDITION;
    }
}
