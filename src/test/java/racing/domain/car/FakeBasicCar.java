package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.BasicFuel;
import racing.domain.fuel.Fuel;

// Fake 객체
public final class FakeBasicCar extends Car {
    private static final Location CHEAT_LOCATION = new Location(1000000000);
    public FakeBasicCar(Name name) {
        super(name, CHEAT_LOCATION);
    }

    @Override
    public Car move(Fuel fuel) {
        return this;
    }
}
