package racinggame;

import racinggame.exception.CarNameLengthExceedException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final MoveStrategy moveStrategy;
    private int position = 1;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    private static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthExceedException();
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }
}
