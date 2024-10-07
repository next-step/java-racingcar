package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {
    private final List<AttemptResult> attemptResults;
    private final List<String> winners;

    public RaceResult(List<AttemptResult> attemptResults, List<String> winners) {
        this.attemptResults = attemptResults;
        this.winners = winners;
    }

    public List<AttemptResult> getAttemptResults() {
        return new ArrayList<>(this.attemptResults);
    }

    public List<String> getWinners() {
        return new ArrayList<>(this.winners);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceResult that = (RaceResult) o;
        return Objects.equals(attemptResults, that.attemptResults) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptResults, winners);
    }
}
