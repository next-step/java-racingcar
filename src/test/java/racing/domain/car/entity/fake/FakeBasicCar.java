package racing.domain.car.entity.fake;

import racing.domain.car.entity.BasicCar;
import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.dto.Turn;

// Fake 객체
public final class FakeBasicCar extends BasicCar {
    private Location location;

    private static final Location CHEAT_LOCATION = new Location(100);
    public FakeBasicCar(Name name) {
        super(name);
        location = Location.empty();
    }

    @Override
    public void move(Turn turn, Fuel fuel) {
        this.location = location.add(
                CHEAT_LOCATION
        );
        turn.register(this, location);
    }
}
