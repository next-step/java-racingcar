package racingcar.vehicle;

import racingcar.vehicle.engine.Engine;

public class Car {

    private final Engine engine;
    private final CarName name;

    private Distance distance;

    public Car(Engine engine, String name, Distance distance) {
        this.engine = engine;
        this.name = new CarName(name);
        this.distance = distance;
    }

    public void drive(int number) {
        int moveDistance = engine.operate(number);
        distance = distance.move(moveDistance);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.get();
    }
}
