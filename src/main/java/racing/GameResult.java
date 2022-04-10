package racing;

import racing.model.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private final List<GameRoundResult> rounds = new ArrayList<>();

    public List<GameRoundResult> getRounds() {
        return rounds;
    }

    public void addRoundResult(GameRoundResult round) {
        Objects.requireNonNull(round);
        rounds.add(round);
    }

    public static class GameRoundResult {
        private final List<Counter> statusList = new ArrayList<>();

        public List<Counter> getStatusList() {
            return statusList;
        }

        public void addResult(Counter status) {
            Objects.requireNonNull(status);
            statusList.add(status);
        }
    }
}
