package racing.race;

import java.util.*;

public class RaceRecord {

    private final List<RaceGauge> results;

    public RaceRecord(List<RaceGauge> results) {
        this.results = results;
    }

    public RaceGauge raceResult(int attempt) {
        return results.get(attempt);
    }
}
