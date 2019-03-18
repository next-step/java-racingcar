package racingcar.view.web;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RacingCar;

public class GameResult {
    private List<Race> raceResults;
    private List<String> winnerNames;

    public GameResult() {
        this.raceResults = new ArrayList<>();
    }

    List<Race> addRaceResult(Race raceResult) {
        raceResults.add(raceResult);

        return this.raceResults;
    }

    void endGame() {
        List<RacingCar> winners = raceResults.get(raceResults.size() - 1).getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.add(winners.get(i).getName());
        }

        this.winnerNames = winnerNames;
    }

    public List<Race> getRaceResults() {
        return raceResults;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
