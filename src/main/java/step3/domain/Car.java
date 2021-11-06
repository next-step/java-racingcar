package step3.domain;

import step3.utils.RandomUtils;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private int position;

    private Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (isMove()) {
            position++;
        }
    }

    private boolean isMove() {
        return RandomUtils.nextInt() >= MOVE_CONDITION;
    }
}
