package racingcar;

public class Car {
    private int position;

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isForward()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
