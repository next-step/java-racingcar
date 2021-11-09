package step3.domain.board;

import step3.domain.car.Location;
import step3.domain.car.Name;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkArgument;

public class CarSnapshot {

    private final Name name;
    private final Location location;

    public CarSnapshot(Location location, Name name) {
        checkArguments(location, name);
        this.location = location;
        this.name = name;
    }

    private void checkArguments(Location location, Name name) {
        checkArgument(location != null, "location is Required");
        checkArgument(name != null, "name is Required");
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSnapshot snapshot = (CarSnapshot) o;
        return Objects.equals(name, snapshot.name) && Objects.equals(location, snapshot.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
