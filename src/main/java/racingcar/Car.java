package racingcar;

public class Car {
    private int position;

    public void move(MoveStrategy moveStrategy, int number) {
        if (moveStrategy.isForward(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
