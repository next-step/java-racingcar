package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSnapshot {
    private final List<CarSnapshot> carSnapshots = new ArrayList<>();

    public void record(CarSnapshot snapShot) {
        carSnapshots.add(snapShot);
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
