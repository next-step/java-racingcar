package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;
import racingcar.vo.car.Location;
import racingcar.vo.car.Name;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public int move(MovementStrategy movementStrategy) {
        if (movementStrategy.isMovable()) {
            location.forward();
        }

        return location.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
