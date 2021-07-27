package racing.domain.car;

import racing.domain.fuel.Fuel;
import racing.domain.Location;

public interface Car {
    Location move(Fuel fuel);
}
