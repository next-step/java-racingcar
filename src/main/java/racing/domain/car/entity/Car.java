package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.fuel.Fuel;

public interface Car {
    Location move(Fuel fuel);
}
