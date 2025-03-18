package racinggame;

import racinggame.exception.CarNameLengthExceedException;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 1;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameLengthExceedException();
        }
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }
}
