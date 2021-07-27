package racing.domain.car;

import racing.domain.car.BasicCar;
import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

// Fake 객체
public final class FakeBasicCar extends BasicCar {
    private Location location;

    private static final Location CHEAT_LOCATION = new Location(100);
    public FakeBasicCar(Name name) {
        super(name);
        location = Location.empty();
    }

    @Override
    public Location move(Fuel fuel) {
        this.location = location.add(
                CHEAT_LOCATION
        );
        return this.location;
    }
}
