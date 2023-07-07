package racing.model;

import java.util.List;
import java.util.Objects;

public class SimulationResultDto {
    private final List<List<CarVO>> progress;
    private final List<CarVO> winners;

    public SimulationResultDto(List<List<CarVO>> progress, List<CarVO> winners) {
        this.progress = progress;
        this.winners = winners;
    }

    public List<List<CarVO>> getProgress() {
        return progress;
    }

    public List<CarVO> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulationResultDto that = (SimulationResultDto) o;
        return Objects.equals(progress, that.progress) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progress, winners);
    }
}
