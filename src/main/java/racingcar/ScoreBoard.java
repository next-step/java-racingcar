package racingcar;

import java.util.List;

public class ScoreBoard {
    private List<Result> results;
    private List<String> winners;

    public ScoreBoard(List<Result> results, List<String> winners) {
        this.results = results;
        this.winners = winners;
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getWinners() {
        return winners;
    }
}
