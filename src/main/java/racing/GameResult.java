package racing;

import racing.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<GameRoundResult> rounds = new ArrayList<>();

    public void addRoundResult(GameRoundResult round) {
        rounds.add(round);
    }

    public static class GameRoundResult {
        private final List<Counter> statusList = new ArrayList<>();

        public List<Counter> getStatusList() {
            return statusList;
        }

        public void addResult(Counter status) {
            statusList.add(status);
        }
    }

    public List<GameRoundResult> getRounds() {
        return rounds;
    }
}
