package racingcar.car;

import racingcar.engine.PowerEngine;

public class Car {
    private static int START_POSITION = 1;

    private PowerEngine powerEngine;
    private int position;

    private Car(PowerEngine powerEngine) {
        this.position = START_POSITION;
        this.powerEngine = powerEngine;
    }

    public static Car newInstance(PowerEngine powerEngine) {
        return new Car(powerEngine);
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position = this.position + this.powerEngine.go();
    }
}