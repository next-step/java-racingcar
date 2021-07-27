package racing.domain;

import racing.domain.car.Car;
import racing.domain.Location;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Turn {
    private final Map<Car, Location> movementRecord;

    public Turn(Map<Car, Location> movementRecord) {
        this.movementRecord = movementRecord;
    }

    private Optional<Location> findMaxLocation() {
        return movementRecord.values().stream()
                .max(Location::compareTo);
    }

    public List<String> findWinnerNames() {
        Optional<Location> optionalBestLocation = findMaxLocation();
        if (!optionalBestLocation.isPresent())
            throw new EmptyCarException();

        Location bestLocation = optionalBestLocation.get();
        return movementRecord.entrySet().stream()
                .filter(
                        iEntry -> iEntry.getValue().equals(bestLocation)
                )
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public Set<Map.Entry<Car, Location>> entrySet() {
        return movementRecord.entrySet();
    }

    public boolean checkLocation(Car car, Location location) {
        return movementRecord.get(car).equals(location);
    }
}
