package racingcar;

import racingcar.engine.CarEngine;
import racingcar.engine.Engine;

public class Car {

    private final Engine engine;
    private final Distance distance;

    public Car() {
        this.engine = new CarEngine();
        this.distance = new Distance();
    }

    public Car(Engine engine) {
        this.engine = engine;
        this.distance = new Distance();
    }

    public void drive(int number) {
        distance.add(engine.operate(number));
    }

    public int getDistance() {
        return distance.get();
    }
}
