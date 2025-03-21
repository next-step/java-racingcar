package step5.racingcar3.domain;

import step5.racingcar3.exception.CarException;

public class Car {

    private final CarName carName;
    private final CarEngine carEngine;
    private final Position position;

    public Car(CarName carName, CarEngine carEngine) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = new Position();
    }

    public Car(CarName carName, CarEngine carEngine, Position position) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = position;
    }

    public Position position() {
        return position;
    }

    public CarName name() {
        return carName;
    }

    public void run() {
        if (carEngine.canRun()) {
            position.increase();
        }
    }

}
