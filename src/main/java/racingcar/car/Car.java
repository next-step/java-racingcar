package racingcar.car;

import racingcar.engine.PowerEngine;

public class Car {

    private PowerEngine powerEngine;
    private int position;

    private Car(PowerEngine powerEngine) {
        this.position = 1;
        this.powerEngine = powerEngine;
    }

    public static Car newInstance(PowerEngine powerEngine) {
        return new Car(powerEngine);
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (powerEngine.gain() < 4) {
            return;
        }

        this.position = this.position + 1;
    }
}