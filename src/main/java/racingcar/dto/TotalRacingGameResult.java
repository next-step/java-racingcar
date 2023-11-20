package racingcar.dto;

import java.util.List;

public class TotalRacingGameResult {

    private final List<String> gameResults;
    private final List<String> winners;

    public TotalRacingGameResult(List<String> gameResults, List<String> winners) {
        this.gameResults = gameResults;
        this.winners = winners;
    }

    public List<String> getGameResults() {
        return gameResults;
    }

    public List<String> getWinners() {
        return winners;
    }
}
