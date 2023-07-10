package racing.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimulationResultDto {
    private final List<RoundResultDto> roundResults;
    private final List<CarVO> winners;

    public SimulationResultDto(List<List<CarVO>> roundResults, List<CarVO> winners) {
        this.roundResults = roundResults.stream().map(RoundResultDto::new).collect(Collectors.toList());
        this.winners = winners;
    }

    public List<RoundResultDto> getRoundResults() {
        return roundResults;
    }

    public List<CarVO> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimulationResultDto that = (SimulationResultDto) o;
        return Objects.equals(roundResults, that.roundResults) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundResults, winners);
    }
}
