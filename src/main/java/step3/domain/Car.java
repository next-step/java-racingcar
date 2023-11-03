package step3.domain;

public class Car {
    private int position;
    private int MOVE_NUMBER_CONDITION = 4;

    public Car() {
    }

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public int position() {
        return position;
    }

    public void move(int moveNumber) {
        if (isMoveAbleCheck(moveNumber)) {
            position++;
        }
    }

    private boolean isMoveAbleCheck(int moveNumber) {
        return moveNumber >= MOVE_NUMBER_CONDITION;
    }
}
