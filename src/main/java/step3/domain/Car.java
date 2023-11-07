package step3.domain;

import step3.exception.CarNameExceedException;

public class Car {

    private static final int NAME_LENGTH_BOUND = 5;
    private static final int MOVE_BOUND = 4;

    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new CarNameExceedException();
        }
    }

    public void move(int random) {
        if (canMove(random)) {
            position++;
        }
    }

    private boolean canMove(int random) {
        return random >= MOVE_BOUND;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

}
