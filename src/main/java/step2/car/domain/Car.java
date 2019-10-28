package step2.car.domain;

import step2.car.domain.engine.Engine;

public class Car {
    private static final Integer MINIMUM_POWER = 4;

    private String name;
    private Engine engine;
    private Integer position = 0;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void move() {
        int power = engine.getPower();
        if (isEnough(power)) {
            this.position++;
        }
    }

    private boolean isEnough(int power) {
        return power >= MINIMUM_POWER;
    }
}
