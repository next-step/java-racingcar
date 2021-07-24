package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

// 이동할때 연료가 들지 않는 꿈의 자동차!!
public final class DreamCar extends BasicCar {
    public DreamCar(Name name) {
        super(name);
    }

    @Override
    public void move(Fuel fuel) {
        super.location = location().add(
                Location.oneBlock()
        );
    }
}
