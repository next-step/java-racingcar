package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVE_CONDITION_SIZE = 4;
    private int position;

    public Car() {
        position = START_POSITION;
    }

    public void move(int number) {
        if (isMoveAble(number)) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    boolean isMoveAble(int number) {
        return MOVE_CONDITION_SIZE <= number;
    }
}
