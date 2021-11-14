package step3.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameHistory {
    private final Map<Integer, RoundHistory> gameHistory;

    private GameHistory() {
        this.gameHistory = new LinkedHashMap<>();
    }

    public static GameHistory create() {
        return new GameHistory();
    }

    public void record(int round, RoundHistory roundHistory) {
        gameHistory.put(round, roundHistory);
    }

    public Map<Integer, RoundHistory> getAll() {
        return gameHistory;
    }

    public RoundHistory getBy(int round) {
        checkContainsRound(round);
        return gameHistory.get(round);
    }

    public List<GameWinner> getGameWinnersBy(int round) {
        RoundHistory lastRound = getBy(round);
        return lastRound.getCarList().stream()
                .filter(car -> car.getPosition() == lastRound.getMaxPosition())
                .map(car -> GameWinner.of(car.getName()))
                .collect(Collectors.toList());
    }

    private void checkContainsRound(int round) {
        if (!gameHistory.containsKey(round)) {
            throw new IllegalArgumentException("라운드 " + round + " 기록이 존재하지 않습니다.");
        }
    }
}
