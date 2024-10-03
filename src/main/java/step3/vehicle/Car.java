package step3.vehicle;

import step3.util.NumberGenerator;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int location = 1;

    public void move(NumberGenerator generator) {
        if (isMovable(generator.getValue())) {
            this.location++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    public int getLocation() {
        return this.location;
    }

}
