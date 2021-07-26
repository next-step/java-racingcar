package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.dto.Turn;

import java.util.Objects;

public class BasicCar implements Car {
    private static final int REQUIRED_FUEL_VALUE = 4; // 자동차가 움직이기 위한 최소 연료
    private final Name name;
    private Location location;

    public BasicCar(Name name) {
        this.name = name;
        this.location = Location.empty();
    }

    public void move(Turn turn, Fuel fuel) {
        if (fuel.isMovable())
            this.location = location.add(Location.oneBlock());
        turn.register(this, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicCar basicCar = (BasicCar) o;
        return name.equals(basicCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
