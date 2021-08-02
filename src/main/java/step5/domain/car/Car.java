package step5.domain.car;

import step5.domain.Number;

public class Car {

    private static final int STAY_THRESHOLD = 3;

    private final Name name;

    private int movedDistance = 0;

    public Car(String name) {
        this.name = new Name(name);
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

    public Name getName() {
        return name;
    }
}
