package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;

import java.util.Objects;

public class BasicCar implements Car {
    private final Name name;
    private Location location;

    public BasicCar(Name name) {
        this.name = name;
        this.location = Location.empty();
    }

    public Location move(Fuel fuel) {
        if (fuel.isMovable())
            this.location = location.add(Location.oneBlock());
        return location;
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
