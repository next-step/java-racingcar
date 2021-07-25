package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

public interface Car {
    default boolean checkLocation(Location location) {
        return location().equals(location);
    }

    Location location();

    Name name();

    void move(Fuel fuel);
}
