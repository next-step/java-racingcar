package race.model;

import java.util.List;

public class RaceResult {
    private List<RaceRecord> raceResult;


    public List<RaceRecord> getResult() {
        return raceResult;
    }

    public RaceResult(List<RaceRecord> raceResult) {
        this.raceResult = raceResult;
    }
}
