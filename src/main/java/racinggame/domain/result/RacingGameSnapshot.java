package racinggame.domain.result;

import racinggame.domain.exception.RacingGameException;

import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class RacingGameSnapshot {
    private final List<CarSnapshot> carSnapshots;

    public RacingGameSnapshot(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }

    public List<String> findWinner() {
        int maxPosition = getMaxLocation();

        return carSnapshots.stream()
                .filter(carSnapshot -> carSnapshot.getLocation() == maxPosition)
                .map(CarSnapshot::getName)
                .collect(toList());
    }

    private int getMaxLocation() {
        return carSnapshots.stream()
                .max(comparingInt(CarSnapshot::getLocation))
                .orElseThrow(RacingGameException::ofNotExistSnapshots)
                .getLocation();
    }

}
