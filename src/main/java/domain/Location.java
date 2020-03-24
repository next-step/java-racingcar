package domain;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private Car car;
    private List<Integer> locations;
    private int lastLocation;

    public Location(Car car) {
        this.car = car;
        this.locations = new ArrayList<>();
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public int getLastLocation() {
        return lastLocation;
    }

    public void saveCurrentLocation() {
        lastLocation = car.getCurrentLocation();
        locations.add(car.getCurrentLocation());
    }

    public String getName() {
        return car.getName();
    }
}
