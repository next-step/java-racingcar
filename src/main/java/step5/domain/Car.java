package step5.domain;

import step5.domain.primitivewrapper.Name;

public class Car {

    private static final int CONDITION_OF_MOVE = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

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

    public int position() {
        return this.position;
    }

    public String carName() {
        return this.name.toString();
    }

    public void moveForward(int power) {
        if(isOutOfRange(power)) {
            throw new IllegalArgumentException("입력 가능한 숫자의 범위를 벗어납니다.");
        }

        if (isMovable(power)) {
            this.position++;
        }
    }

    private boolean isOutOfRange(int power) {
        return power < MIN_RANGE || power > MAX_RANGE;
    }

    private boolean isMovable(int power) {
        return power >= CONDITION_OF_MOVE;
    }

    public int comparePosition(int position) {
        return Math.max(position, this.position);
    }

    public boolean isMaxPosition(int max) {
        return this.position == max;
    }
}
