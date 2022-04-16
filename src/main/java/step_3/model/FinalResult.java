package step_3.model;

import java.util.ArrayList;
import java.util.List;

public class FinalResult {

    private final List<RoundResult> roundResults;

    public FinalResult() {
        this.roundResults = new ArrayList<>();
    }

    public void record(RoundResult roundResult) {
        this.roundResults.add(roundResult);
    }

    public void record(FinalResult finalResult) {
        this.roundResults.addAll(finalResult.getRoundResults());
    }

    public List<RoundResult> getRoundResults() {
        return this.roundResults;
    }
}
