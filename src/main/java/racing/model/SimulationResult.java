package racing.model;

import java.util.List;
import java.util.Objects;

public class SimulationResult {
    private List<List<CarVO>> progress;
    private List<String> winners;

    public SimulationResult(List<List<CarVO>> progress, List<String> winners) {
        this.progress = progress;
        this.winners = winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulationResult that = (SimulationResult) o;
        return Objects.equals(progress, that.progress) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progress, winners);
    }

    public List<List<CarVO>> getProgress() {
        return progress;
    }

    public List<String> getWinners() {
        return winners;
    }
}
