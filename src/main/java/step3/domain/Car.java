package step3.domain;

public class Car {

    private int position;
    private static final int MOVE_NUMBER_CONDITION = 4;

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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
