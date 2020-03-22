package racingcar.domain;

import java.util.Map;

public class RacingGameResults {
    private final Map<Integer, Cars> racingGameHistory;

    public RacingGameResults(Map<Integer, Cars> racingGameHistory) {
        this.racingGameHistory = racingGameHistory;
    }

    public String getRenderedGameResults() {
        StringBuilder collectResult = new StringBuilder();
        racingGameHistory.entrySet()
                .stream()
                .forEach(e -> collectResult.append(e.getValue().getResults()));
        return collectResult.toString();
    }

}
