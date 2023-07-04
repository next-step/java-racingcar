package racing;

import java.util.List;
import java.util.Objects;

public class SimulationResult {
    private List<String> names;
    private List<List<Integer>> progress;
    private List<String> winners;

    public SimulationResult(List<String> names, List<List<Integer>> progress, List<String> winners) {
        this.names = names;
        this.progress = progress;
        this.winners = winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulationResult that = (SimulationResult) o;
        return Objects.equals(names, that.names) && Objects.equals(progress, that.progress) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names, progress, winners);
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<Integer>> getProgress() {
        return progress;
    }

    public List<String> getWinners() {
        return winners;
    }
}
