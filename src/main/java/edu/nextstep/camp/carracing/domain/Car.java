package edu.nextstep.camp.carracing.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_SYMBOL = "-";

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            this.position.increment();
        }
    }

    public String getCurrentPositionString() {
        return String.format("%s : %s", this.name.getName(), MOVE_SYMBOL.repeat(this.position.getValue()));
    }

    public boolean isMaxPosition(int position) {
        return this.position.isSame(position);
    }

    public int getMaxValue(int value) {
        return this.position.max(value);
    }

    public CarName getName() {
        return this.name;
    }
}
