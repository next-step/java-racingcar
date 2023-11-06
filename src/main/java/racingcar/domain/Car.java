package racingcar.domain;

public class Car {
    private int position = 0;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveAble()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
