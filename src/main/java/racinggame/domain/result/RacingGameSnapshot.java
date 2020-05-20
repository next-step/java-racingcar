package racinggame.domain.result;

import racinggame.domain.exception.RacingGameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class RacingGameSnapshot {
    private final Map<String, CarSnapshot> carSnapshots;

    public RacingGameSnapshot(Map<String, CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<String> findWinners() {
        int maxPosition = findMaximumLocation();

        return carSnapshots.values().stream()
                .filter(carSnapshot -> carSnapshot.getLocation() == maxPosition)
                .map(CarSnapshot::getName)
                .collect(toList());
    }

    private int findMaximumLocation() {
        return carSnapshots.values().stream()
                .max(comparingInt(CarSnapshot::getLocation))
                .orElseThrow(RacingGameException::ofNotExistSnapshots)
                .getLocation();
    }

    public List<CarSnapshot> getCarSnapshots() {
        return new ArrayList<>(this.carSnapshots.values());
    }


}
