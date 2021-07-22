package racingcar;

import racingcar.engine.CarEngine;
import racingcar.engine.Engine;

public class Car {

    private final Engine engine = new CarEngine();
    private final Distance distance;

    public Car() {
        this.distance = new Distance();
    }

    public void drive(int number) {
        distance.add(engine.operate(number));
    }

    public int getDistance() {
        return distance.get();
    }
}
