package racingcar.backend.domain;

public class Car {

    private static final int ZERO = 0;
    private int position;

    public Car() {
        this.position = ZERO;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
