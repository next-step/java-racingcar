package racing.model;

import java.util.Collections;
import java.util.List;

public class RoundResult {
    private final List<CarSnapshot> carSnapshots;

    private RoundResult(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarInfos() {
        return Collections.unmodifiableList(carSnapshots);
    }

    public static RoundResult save(List<CarSnapshot> carSnapshots) {
        return new RoundResult(carSnapshots);
    }
}
