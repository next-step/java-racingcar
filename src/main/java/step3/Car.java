package step3;

public class Car {
    private int position;

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
        return moveNumber >= 4;
    }

    public String drawPosition() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
