package step3.domain.car;

import step3.domain.oil.Power;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.domain.oil.Power.SUFFICIENT;
import static step3.utils.ValidationUtils.checkArgument;

public class Location {

    private int currentLocation;

    private final List<Integer> timeBasedLocations = new ArrayList<>();

    public static Location createOn(Integer initialLocation) {
        return new Location(initialLocation);
    }

    private Location(Integer initialLocation) {
        checkArgument(initialLocation != null, "initialLocation is required");
        this.currentLocation = initialLocation;
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
