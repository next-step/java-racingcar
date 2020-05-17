package racingcar.domain;

public class Car {
    private static final int MOVABLE_CONDITION = 4;
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveNumber) {
        if (isMove(moveNumber)) {
            position++;
        }
    }

    private boolean isMove(int moveNumber) {
        return moveNumber >= MOVABLE_CONDITION;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
