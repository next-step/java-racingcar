package racingcar.view.web;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<RaceResult> raceResults;
    private List<String> winnerNames;

    public GameResult() {
        this.raceResults = new ArrayList<>();
    }

    public List<RaceResult> addRaceResult(RaceResult raceResult) {
        raceResults.add(raceResult);

        return this.raceResults;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public void setWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }
}
