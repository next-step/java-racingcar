package racinggame.domain.result;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameSnapshot> results;

    public RacingGameResult(List<RacingGameSnapshot> results) {
        this.results = results;
    }

    public List<RacingGameSnapshot> getResults() {
        return results;
    }

    public List<String> findFinalWinners() {
        int finalRound = results.size() - 1;
        return findWinnersOfRound(finalRound);
    }

    private List<String> findWinnersOfRound(final int round) {
        return results.get(round)
                .findWinner();
    }

    public int size() {
        return results.size();
    }
}
