package step3.domain.history;

import step3.domain.GameWinner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameHistory {
    private static final int LAST_ROUND = 0;

    private Map<Integer, RoundHistory> gameHistory;

    private GameHistory() {
        this.gameHistory = new LinkedHashMap<>();
    }

    public static GameHistory create() {
        return new GameHistory();
    }

    public void record(Integer round, RoundHistory roundHistory) {
        gameHistory.put(round, roundHistory);
    }

    public Map<Integer, RoundHistory> getAll() {
        return gameHistory;
    }

    public List<GameWinner> getGameWinners() {
        RoundHistory roundHistory = gameHistory.get(LAST_ROUND);
        return roundHistory.getCarList().stream()
                .filter(car -> car.getPosition() == roundHistory.getMaxPosition())
                .map(GameWinner::new)
                .collect(Collectors.toList());
    }
}
