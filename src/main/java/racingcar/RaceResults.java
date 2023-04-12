package racingcar;

import java.util.List;

public class RaceResults {

    private final List<LapResult> lapResults;

    public RaceResults(List<LapResult> lapResults) {
        this.lapResults = lapResults;
    }

    public void recordLapResult(LapResult lapResult) {
        lapResults.add(lapResult);
    }

    public String raceResultsString() {
        String result = "";
        for (LapResult lapResult : lapResults) {
            result += lapResult.lapResultString();
        }
        return result;
    }

}
