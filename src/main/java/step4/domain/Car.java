package step4.domain;

import step4.domain.primitivewrapper.Name;

public class Car {

    private static final int CONDITION_OF_MOVE = 4;
    private static final int[] RANGE_OF_NUMBER = {0, 9};

    private int position;
    private Name name;

    public Car() {
        this.position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public Car(String name) {
        this(0);
        this.name = new Name(name);
    }

    public Car(String name, int position) {
        this(position);
        this.name = new Name(name);
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.name.toString();
    }

    public void moveForward(int power) {
        if(isOutOfRange(power)) {
            throw new IllegalArgumentException("엑셀의 작동 범위를 벗어납니다.");
        }

        if (isMovable(power)) {
            this.position++;
        }
    }

    private boolean isOutOfRange(int power) {
        return power < RANGE_OF_NUMBER[0] || power > RANGE_OF_NUMBER[1];
    }

    private boolean isMovable(int power) {
        return power >= CONDITION_OF_MOVE;
    }

    public int comparePosition(int position) {
        return Math.max(position, this.position);
    }
}
