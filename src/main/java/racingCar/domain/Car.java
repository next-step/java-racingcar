package racingCar.domain;

import java.util.Random;

public class Car {

    private static final int MOVABLE_MIN_NUMBER = 4;
    private final Name name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(new Name(name), position);
    }
    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVABLE_MIN_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.toString();
    }
}