package racinggame.domain.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameResult {
    private final int totalRound;
    private final Map<Integer, RacingGameSnapshot> results = new HashMap<>();

    public RacingGameResult(int totalRound) {
        this.totalRound = totalRound;
    }

    public void record(int round, RacingGameSnapshot gameSnapshot) {
        results.put(round, gameSnapshot);
    }

    public List<String> findFinalWinners() {
        return results.get(totalRound)
                .findWinner();
    }

    public Map<Integer, RacingGameSnapshot> getResults() {
        return results;
    }
}
