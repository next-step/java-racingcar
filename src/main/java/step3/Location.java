package step3;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.Power.SUFFICIENT;

public class Location {

    private int currentLocation;

    private final List<Integer> timeBasedLocations = new ArrayList<>();

    public static Location createOn(Integer initialLocation) {
        return new Location(initialLocation);
    }

    private Location(Integer initialLocation) {
        validateNotNull(initialLocation);
        this.currentLocation = initialLocation;
    }

    private void validateNotNull(Integer initialLocation) {
        if (initialLocation == null) {
            throw new IllegalArgumentException("initialLocation is required");
        }
    }

    public void goForward(Power power) {
        if (power == SUFFICIENT) {
            currentLocation++;
        }
        timeBasedLocations.add(currentLocation);
    }

    public List<Integer> readTrace() {
        return unmodifiableList(timeBasedLocations);
    }
}
