package racingcar.domain;

public class Car {

    private int position = 0;

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
