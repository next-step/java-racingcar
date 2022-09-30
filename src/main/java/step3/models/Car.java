package step3.models;

import step3.exception.ExceedLengthException;
import step3.exception.NullOrEmptyException;

public class Car {
    private static final int MIN_NUM_TO_MOVE = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int position;

    public static Car init(String name) {
        if (name == null || name.isBlank()) {
            throw new NullOrEmptyException();
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedLengthException(MAX_NAME_LENGTH);
        }

        return new Car(name, 0);
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MIN_NUM_TO_MOVE) {
            return new Car(this.name, this.position + 1);
        }

        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
