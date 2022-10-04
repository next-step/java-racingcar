package racingcar.domain;

public class Car {
    private MoveCondition moveCondition;
    private int position;
    private final int MOVE_POSITION = 1;

    public Car(MoveCondition moveCondition) {
        this.position = 0;
        this.moveCondition = moveCondition;
    }

    public int getPosition() {
        return position;
    }

    public int move(int num) {
        if (moveCondition.isMovable(num)) {
            this.position += MOVE_POSITION;
        }
        return position;
    }
}
