package racinggame.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RoundSnapshot {

    private final List<CarSnapshot> carSnapshots;

    public RoundSnapshot(RacingCars cars) {
        this.carSnapshots = makeSnapshot(cars);
    }

    private List<CarSnapshot> makeSnapshot(RacingCars cars) {
        return cars.getCars().stream()
                .map(CarSnapshot::new)
                .collect(toList());
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
