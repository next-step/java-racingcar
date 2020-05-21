package racinggame.domain.result;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final int totalRound;
    private final List<RacingGameSnapshot> results = new ArrayList<>();

    public RacingGameResult(int totalRound) {
        this.totalRound = totalRound;
    }

    public void record(RacingGameSnapshot gameSnapshot) {
        results.add(gameSnapshot);
    }

    public List<String> findFinalWinners() {
        return results.get(totalRound - 1)
                .findWinners();
    }

    public List<RacingGameSnapshot> getResults() {
        return results;
    }
}
