package step3;

public class Car {
    private int position;
    private int MOVE_NUMBER_CONDITION = 4;

    public Car() {
    }

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public int nowPosition() {
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
