package step3.collections;

import java.util.List;
import java.util.Objects;

public class RaceResult {

    private final List<AttemptResult> attemptResults;

    public RaceResult(List<AttemptResult> attemptResults) {
        this.attemptResults = attemptResults;
    }

    public int getFinalWinnerCarNumber() {
        return getLastAttemptResult().getFirstCarNumber();
    }

    public List<AttemptResult> getAttemptResults() {
        return attemptResults;
    }

    private AttemptResult getLastAttemptResult() {
        return this.attemptResults.get(attemptResults.size()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult that = (RaceResult) o;
        return attemptResults.equals(that.attemptResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptResults);
    }

}
