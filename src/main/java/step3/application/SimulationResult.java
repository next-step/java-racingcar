package step3.application;

import step3.domain.RacingCar;
import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.Collections;
import java.util.List;

public class SimulationResult {
    private final List<Snapshot> snapshots;
    private final List<RacingCar> racingCars;
    private final List<String> winners;

    public SimulationResult(final List<Snapshot> snapshots, final RacingMap racingMap) {
        this.snapshots = Collections.unmodifiableList(snapshots);
        this.racingCars = racingMap.getRacingCars();
        final List<String> winners = racingMap.selectWinnerNames(); 
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> getWinners() {
        return winners;
    }
}
