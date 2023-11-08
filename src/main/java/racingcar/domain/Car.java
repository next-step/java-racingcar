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

    public void moveForwardByCondition(int number) {
        if (isMovable(number)) {
            this.position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber > MOVE_CONDITION;
    }
}
