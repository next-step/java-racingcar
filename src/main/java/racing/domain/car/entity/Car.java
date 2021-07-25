package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;

public interface Car {
    default boolean checkLocation(Location location) {
        return location().equals(location);
    }

    Location location();

    Name name();

    void move(Fuel fuel);
}
