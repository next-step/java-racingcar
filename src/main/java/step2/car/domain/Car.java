package step2.car.domain;

import step2.car.domain.engine.Engine;

public class Car {
    private static final Integer MINIMUM_POWER = 4;

    private final Status status;
    private final Engine engine;

    public Car(String name, Engine engine) {
        this.status = new Status(name);
        this.engine = engine;
    }

    public Status getStatus() {
        return new Status(this.status);
    }

    public String getName() {
        return this.status.getName();
    }

    public Integer getPosition() {
        return this.status.getPosition();
    }

    public void move() {
        int power = engine.getPower();
        if (isEnough(power)) {
            this.status.forward();
        }
    }

    private boolean isEnough(int power) {
        return power >= MINIMUM_POWER;
    }

}
