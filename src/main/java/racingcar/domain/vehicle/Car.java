package racingcar.domain.vehicle;

import racingcar.domain.engine.Engine;

public class Car {

    private static final int DRIVE_FLAG = 4;
    private static final int DRIVE_DISTANCE = 1;

    private final Engine engine;
    private final Name name;

    private Distance distance;

    public Car(Engine engine, String name, Distance distance) {
        this.engine = engine;
        this.name = new Name(name);
        this.distance = distance;
    }

    public void drive() {
        if (engine.running() >= DRIVE_FLAG) {
            distance = distance.move(DRIVE_DISTANCE);
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public Name getName() {
        return name;
    }

    public String getNameValue() {
        return name.toString();
    }

    public Distance getDistance() {
        return distance;
    }

    public int getDistanceValue() {
        return distance.getValue();
    }
}
