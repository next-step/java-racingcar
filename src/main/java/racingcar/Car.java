package racingcar;

import racingcar.common.Properties;
import racingcar.engine.CarEngine;
import racingcar.engine.Engine;

public class Car {

    private final Engine engine;

    private Distance distance;

    public Car() {
        this.engine = new CarEngine();
        this.distance = new Distance(Properties.INIT_DISTANCE);
    }

    public Car(Engine engine) {
        this.engine = engine;
        this.distance = new Distance(Properties.INIT_DISTANCE);
    }

    public void drive(int number) {
        int moveDistance = engine.operate(number);
        distance = distance.move(moveDistance);
    }

    public int getDistance() {
        return distance.get();
    }
}
