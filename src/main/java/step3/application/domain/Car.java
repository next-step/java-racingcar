package step3.application.domain;

import error.ErrorMessage;

public class Car {

    private final int id;
    private int location;
    public static final int INIT_POSITION = 0;

    public Car(int id) {
        validateId(id);
        this.id = id;
        this.location = INIT_POSITION;
    }

    public int verifyLocation() {
        return location;
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_NUMBER.print());
        }
    }

    public int move(boolean isMovable) {
        if (isMovable) {
            this.location += 1;
        }
        return this.location;
    }
}