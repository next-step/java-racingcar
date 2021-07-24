package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

// Fake 객체
public final class FakeCar extends BasicCar {
    private Location location;
    public FakeCar(Name name) {
        super(name);
        location = Location.empty();
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public void move(Fuel fuel) {
        this.location = location().add(
                Location.oneBlock()
        );
    }
}
