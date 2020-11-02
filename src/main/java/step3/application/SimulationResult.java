package step3.application;

import step3.domain.RacingCar;
import step3.domain.Snapshot;

import java.util.Collections;
import java.util.List;

public class SimulationResult {
    private final List<Snapshot> snapshots;
    private final List<RacingCar> racingCars;

    public SimulationResult(final List<Snapshot> snapshots, final List<RacingCar> racingCars) {
        this.snapshots = Collections.unmodifiableList(snapshots);
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
