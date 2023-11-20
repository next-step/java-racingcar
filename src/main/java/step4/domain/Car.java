package step4.domain;

import step4.strategy.MovingStrategy;

public class Car {
    private final Name name;
    private MovingStrategy movingStrategy;
    private int distance;


    public Car(String name, MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }

    Car(String name) {
        this.name = new Name(name);
    }

    Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = distance;
    }

    public String name() {
        return this.name.name();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canForward()) {
            distance++;
        }
    }

    public void move() {
        if (movingStrategy.canForward()) {
            distance++;
        }
    }

    public int distance() {
        return this.distance;
    }
}
