package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LocationRecord {

    private List<Location> locations;

    public LocationRecord(List<Car> cars) {
        this.locations = createLocations(cars);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void saveCurrentLocation() {
        for (Location location : locations) {
            location.saveCurrentLocation();
        }
    }

    public Location getMaxLocation() {
        return Collections.max(locations,
                Comparator.comparing(s -> s.getLastLocation()));
    }

    private List<Location> createLocations(List<Car> cars) {
        List<Location> locations = new ArrayList<>();
        for (Car car : cars) {
            locations.add(new Location(car));
        }

        return locations;
    }

}
