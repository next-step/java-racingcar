package racingcar_tdd.domain;

import java.util.Random;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private final int NAME_MAX_LENGTH_EXCLUSIVE = 10;
    private final int GO_CONDITION_NUMBER = 4;

    private Name name;
    private int position = 0;

    public Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        this(new Name(name), position);
        this.position = position;
    }

    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return this.position;
    }

    private Random rand = new Random();
    public void move() {
        this.move(rand.nextInt(NAME_MAX_LENGTH_EXCLUSIVE));
    }

    public void move(final int condition) {
        if (condition >= GO_CONDITION_NUMBER) {
            this.position++;
        }
    }
}
