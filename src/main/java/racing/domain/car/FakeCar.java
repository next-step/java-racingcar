package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

// Fake 객체
public final class FakeCar extends BasicCar {
    public FakeCar(Name name) {
        super(name);
    }

    @Override
    public void move(Fuel fuel) {
        super.location = location().add(
                Location.oneBlock()
        );
    }
}
