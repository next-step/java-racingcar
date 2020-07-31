package step3;

import java.util.List;

public class RaceResult {

    private List<AttemptResult> attemptResults;

    public RaceResult(List<AttemptResult> attemptResults) {
        this.attemptResults = attemptResults;
    }

    public Integer getFinalWinnerCarNumber() {
        return attemptResults.get(attemptResults.size()-1).getFistCarNumber();
    }

    Integer attemptResultsSize() {
        return this.attemptResults.size();
    }
}
