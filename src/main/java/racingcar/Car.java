package racingcar;

public class Car {
    private int position;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
