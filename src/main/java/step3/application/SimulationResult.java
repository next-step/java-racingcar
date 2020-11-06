package step3.application;

import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.Collections;
import java.util.List;

public class SimulationResult {
    private final List<Snapshot> snapshots;
    private final List<String> winners;

    public SimulationResult(final List<Snapshot> snapshots) {
        this.snapshots = Collections.unmodifiableList(snapshots);
        final Snapshot lastSnapshot = snapshots.get(snapshots.size() - 1);
        final RacingMap lastRacingMap = lastSnapshot.getRacingMap();
        final List<String> winners = lastRacingMap.selectWinnerNames();
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public List<String> getWinners() {
        return winners;
    }
}
