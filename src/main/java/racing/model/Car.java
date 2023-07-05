package racing.model;

import racing.exception.IllegalCarNameException;

public class Car {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private int position;
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 1;
    }

    private void validate(String name) {
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalCarNameException();
        }
    }

    public void goForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
