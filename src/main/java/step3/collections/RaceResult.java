package step3.collections;

import java.util.List;

public class RaceResult {

    private final List<AttemptResult> attemptResults;

    public RaceResult(List<AttemptResult> attemptResults) {
        this.attemptResults = attemptResults;
    }

    public Integer getFinalWinnerCarNumber() {
        return attemptResults.get(attemptResults.size()-1).getFistCarNumber();
    }

    public List<AttemptResult> getAttemptResults() {
        return attemptResults;
    }

}
