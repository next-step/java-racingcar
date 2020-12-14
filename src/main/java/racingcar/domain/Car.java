package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Location location;

    public Car(String name, int location) {
        this.name = new Name(name);
        this.location = new Location(location);
    }

    public String getName() {
        return this.name.getNameValue();
    }

    public int getLocation() {
        return this.location.getLocationValue();
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            this.location.moveLocation();
        }
    }
}
