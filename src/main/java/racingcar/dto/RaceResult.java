package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<AttemptResult> attemptResults;
    private final List<String> winners;

    public RaceResult(final List<String> winners) {
        this(new ArrayList<>(), winners);
    }

    public RaceResult(final List<AttemptResult> attemptResults, final List<String> winners) {
        this.attemptResults = attemptResults;
        this.winners = winners;
    }

    public List<AttemptResult> getAttemptResults() {
        return new ArrayList<>(this.attemptResults);
    }

    public List<String> getWinners() {
        return new ArrayList<>(this.winners);
    }

    public String formatAttempts(String lineSeparator) {
        return attemptResults.stream()
                .map(attemptResult -> attemptResult.formatAttempt(lineSeparator))
                .collect(Collectors.joining());
    }

    public String joinWinners() {
        return String.join(", ", this.winners);
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

    @Override
    public String toString() {
        return "RaceResult{" +
                "attemptResults=" + attemptResults +
                ", winners=" + winners +
                '}';
    }
}
