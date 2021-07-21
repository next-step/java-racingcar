package racingcar;

import racingcar.engine.CarEngine;
import racingcar.engine.Engine;

public class Car {

    private final Engine engine = new CarEngine();

    private int distance = 0;

    public void drive(int number) {
        distance += engine.operate(number);
    }

    public int getDistance() {
        return distance;
    }
}
