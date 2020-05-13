package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSnapshot {
    private final List<CarSnapShot> carSnapShots = new ArrayList<>();

    public void record(CarSnapShot snapShot) {
        carSnapShots.add(snapShot);
    }

    public List<CarSnapShot> getCarSnapShots() {
        return carSnapShots;
    }
}
