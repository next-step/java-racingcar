package racing.domain.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreBoard {
    private final List<RaceResult> raceResults;

    public ScoreBoard() {
        this.raceResults = new ArrayList<>();
    }

    public void addResult(final RaceResult raceResult) {
        raceResults.add(raceResult);
    }

    public List<RaceResult> raceResults() {
        return raceResults;
    }

    public List<Record> winners() {
        RaceResult lastRaceResult = getLastRaceResult();
        return lastRaceResult.winners();
    }

    private RaceResult getLastRaceResult() {
        return raceResults.get(raceResults.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScoreBoard that = (ScoreBoard) o;
        return Objects.equals(raceResults, that.raceResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceResults);
    }
}
