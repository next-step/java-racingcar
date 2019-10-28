package step2.car.domain.car;

import step2.car.domain.car.engine.Engine;

public class Car {
    private static final Integer MINIMUM_POWER = 4;

    private Engine engine;
    private Integer position = 0;

    public Car(Engine engine) {
        this.engine = engine;
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
