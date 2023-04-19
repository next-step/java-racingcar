package racing.domain;

import racing.util.InputValidator;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.position = 0;
        this.name = InputValidator.validateCarName(name);
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }
}
