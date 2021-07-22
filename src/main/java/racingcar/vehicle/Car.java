package racingcar.vehicle;

import racingcar.Distance;
import racingcar.engine.Engine;

public class Car {

    private final Engine engine;

    private Distance distance;

    public Car(Engine engine, int distance) {
        this.engine = engine;
        this.distance = new Distance(distance);
    }

    public void drive(int number) {
        int moveDistance = engine.operate(number);
        distance = distance.move(moveDistance);
    }

    public int getDistance() {
        return distance.get();
    }
}
