package step5.worker.application;

import step5.worker.domain.Snapshot;

import java.util.Collections;
import java.util.List;

public class SimulationResponse {
    private final List<Snapshot> snapshots;
    private final List<String> winners;

    public SimulationResponse(final List<Snapshot> snapshots, final List<String> winners) {
        this.snapshots = Collections.unmodifiableList(snapshots);
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<Snapshot> getSnapshots() {
        return snapshots;
    }

    public List<String> getWinners() {
        return winners;
    }
}
