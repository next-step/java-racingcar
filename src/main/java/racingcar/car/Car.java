package racingcar.car;

import racingcar.engine.PowerEngine;

public class Car {
    private static int START_POSITION = 0;

    private CarName carName;
    private PowerEngine powerEngine;
    private int position;

    private Car(CarName carName, PowerEngine powerEngine) {
        this.position = START_POSITION;
        this.carName = carName;
        this.powerEngine = powerEngine;
    }

    private Car(PowerEngine powerEngine) {
        this.position = START_POSITION;
        this.powerEngine = powerEngine;
    }

    public static Car newInstance(PowerEngine powerEngine) {
        return new Car(powerEngine);
    }

    public static Car newInstance(CarName carName, PowerEngine powerEngine) {
        return new Car(carName, powerEngine);
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position = this.position + this.powerEngine.go();
    }

    public String getName() {
        return this.carName.getName();
    }
}