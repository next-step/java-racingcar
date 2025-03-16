package edu.nextstep.camp.carracing;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_SYMBOL = "-";

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getPositionString() {
        return MOVE_SYMBOL.repeat(position);
    }
}
