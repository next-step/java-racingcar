package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.Location;
import racinggame.domain.Name;

public class RoundLog {

    private final Name name;
    private final Location location;

    private RoundLog(String name, int location) {
        this.name = new Name(name);
        this.location = new Location(location);
    }

    public static RoundLog from(Car car) {
        return new RoundLog(car.getName(), car.getLocation());
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
}
