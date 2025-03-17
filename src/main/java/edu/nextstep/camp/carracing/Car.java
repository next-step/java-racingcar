package edu.nextstep.camp.carracing;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_SYMBOL = "-";

    private final CarName name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCurrentPositionString() {
        return String.format("%s : %s", name.getName(), MOVE_SYMBOL.repeat(position));
    }

    public boolean isMaxPosition(int position) {
        return this.position == position;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
