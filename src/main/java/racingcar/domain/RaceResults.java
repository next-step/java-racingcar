package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {

    private final List<LapResult> lapResults;

    public RaceResults(List<LapResult> lapResults) {
        this.lapResults = lapResults;
    }

    public void recordLapResult(LapResult lapResult) {
        lapResults.add(lapResult);
    }

    public List<LapResult> lapResults() {
        return new ArrayList<>(lapResults);
    }

    public LapResult finalResult() {
        return new LapResult(finalCarPositions());
    }

    private List<Car> finalCarPositions() {
        return finalLapResult().cars();
    }

    private LapResult finalLapResult() {
        return lapResults.get(finalIndex());
    }

    private int finalIndex() {
        return lapResults.size() - 1;
    }

}
