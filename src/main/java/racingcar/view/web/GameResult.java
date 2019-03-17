package racingcar.view.web;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RacingCar;

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

    public static List<String> extractWinnerNamesOf(Race race) {
        List<RacingCar> winners = race.getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }

        return winnerNames;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    void setWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }
}
