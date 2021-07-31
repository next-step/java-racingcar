package step4.car;

import step4.number.Number;

public class Car {

    private static final int STAY_THRESHOLD = 3;

    private final String name;

    private int movedDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove(Number number) {
        if (canMove(number))
            move();
    }

    private void move() {
        this.movedDistance++;
    }

    private boolean canMove(Number number) {
        return number.getValue() > STAY_THRESHOLD;
    }

    public Position getPosition() {
        return new Position(movedDistance);
    }

    public String getName() {
        return name;
    }
}
