package racinggame.domain.car;

import racinggame.domain.Engine;
import racinggame.domain.result.CarSnapshot;

public class Car {
    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name.trim();
    }

    public CarSnapshot move(Engine engine) {
        if (engine.isMovable()) {
            location++;
        }
        return new CarSnapshot(name, location);
    }
}
