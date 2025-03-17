package car_racing.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {
    private final List<RaceResult> raceResults;

    public RaceResults(List<RaceResult> raceResults) {
        this.raceResults = raceResults;
    }

    public List<Integer> getNthRoundResult(int n) {
        List<Integer> result = new ArrayList<>();
        for (RaceResult raceResult : raceResults) {
            result.add(raceResult.getPositionOfNthRound(n));
        }
        return result;
    }
}
