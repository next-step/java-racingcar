package racing.domain.game.vo;

import racing.domain.car.entity.Car;
import racing.domain.car.vo.Location;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Turn {
    private final Map<Car, Location> movementRecord;

    public Turn() {
        movementRecord = new HashMap<>();
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

    public void register(Car car, Location location) {
        this.movementRecord.put(car, location);
    }

    public Set<Map.Entry<Car, Location>> entrySet() {
        return movementRecord.entrySet();
    }

    public boolean checkLocation(Car car, Location location) {
        return movementRecord.get(car).equals(location);
    }
}
