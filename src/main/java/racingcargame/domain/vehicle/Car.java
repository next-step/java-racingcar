package racingcargame.domain.vehicle;

import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.engine.Engine;

public class Car {

    private final Engine engine;
    private final Name name;

    private Distance distance;

    public Car(Engine engine, Name name, Distance distance) {
        this.engine = engine;
        this.name = name;
        this.distance = distance;
    }

    public void drive() {
        distance = distance.forward(engine.running());
    }

    public boolean isEquals(Distance distance) {
        return this.distance.equals(distance);
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
