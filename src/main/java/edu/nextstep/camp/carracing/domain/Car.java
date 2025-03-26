package edu.nextstep.camp.carracing.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            this.position = this.position.increment();
        }
    }

    public boolean isMaxPosition(int position) {
        return this.position.isSame(position);
    }

    public int getMaxValue(int value) {
        return this.position.max(value);
    }

    public String getNameValue() {
        return this.name.getName();
    }

    public Position getPosition() {
        return this.position;
    }
}
