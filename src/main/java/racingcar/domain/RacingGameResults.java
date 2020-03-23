package racingcar.domain;

import java.util.Map;
import java.util.Set;

public class RacingGameResults {
    private final Map<Integer, Cars> racingGameResults;

    public RacingGameResults(Map<Integer, Cars> racingGameResults) {
        this.racingGameResults = racingGameResults;
    }

    public Set<Map.Entry<Integer, Cars>> getGameResultSet() {
        return racingGameResults.entrySet();
    }

    public String getWinner() {
        int lastGameRound = racingGameResults.size() - 1;
        return racingGameResults.get(lastGameRound).getWinner();
    }


}
