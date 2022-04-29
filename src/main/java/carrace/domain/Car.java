package carrace.domain;

import carrace.moving.Moving;
import carrace.moving.RandomMoving;

public class Car {

    private final RandomMoving randomMoving = new RandomMoving();

    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public void move(Moving moving) {
        this.position += moving.move();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
