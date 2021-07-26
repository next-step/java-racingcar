package racing.domain.game.dto;

import racing.domain.car.entity.Car;
import racing.domain.car.vo.Location;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Turn {
    private final Map<Car, Location> movementRecord;

    public Turn() {
        movementRecord = new HashMap<>();
    }

    public void register(Car car, Location location) {
        this.movementRecord.put(car, location);
    }

    public String asString(BiFunction<Car, Location, String> mapper, String dividedString) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Car, Location> iEntry : movementRecord.entrySet()) {
            builder.append(
                    mapper.apply(iEntry.getKey(), iEntry.getValue())
            ).append(dividedString);
        }
        return builder.toString();
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
}
