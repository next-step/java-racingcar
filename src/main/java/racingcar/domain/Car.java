package racingcar.domain;

public class Car {

    private int position;
    private String name;
    private static final int MOVE_NUMBER_CONDITION = 4;

    public Car() {
    }

    public Car(int initPosition) {
        this.position = initPosition;
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(int initPosition, String name) {
        this.position = initPosition;
        this.name = name;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
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
        result.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
