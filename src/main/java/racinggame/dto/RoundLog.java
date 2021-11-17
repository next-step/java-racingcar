package racinggame.dto;

import racinggame.domain.Location;
import racinggame.domain.Name;

public class RoundLog {

    private final Name name;
    private final Location location;

    public RoundLog(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
}
