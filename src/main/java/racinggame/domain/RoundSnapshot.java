package racinggame.domain;

import java.util.List;

public class RoundSnapshot {

    private final List<CarSnapshot> carSnapshots;

    public RoundSnapshot(RacingCars cars) {
         this.carSnapshots = cars.makeSnapshot();
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
