package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;

public class BasicCar implements Car {
    private static final int REQUIRED_FUEL_VALUE = 4; // 자동차가 움직이기 위한 최소 연료
    private final Name name;
    private Location location;

    public BasicCar(Name name) {
        this.name = name;
        this.location = Location.empty();
    }

    public Location location() {
        return location;
    }

    public Name name() {
        return name;
    }

    public void move(Fuel fuel) {
        if (isMovable(fuel))
            this.location = location.add(Location.oneBlock());
    }

    private boolean isMovable(Fuel fuel) {
        return fuel.value() >= REQUIRED_FUEL_VALUE;
    }
}
