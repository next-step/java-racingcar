package racing.dto;

import racing.utils.Counter;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {
    private final List<GameRoundResult> rounds = new ArrayList<>();

    public List<GameRoundResult> getRounds() {
        return rounds;
    }

    public void addRoundResult(GameRoundResult round) {
        Objects.requireNonNull(round);
        rounds.add(round);
    }

    public List<String> getWinners() {
        if (rounds.isEmpty()) {
            throw new IllegalStateException("게임 결과는 진행 후 호출 가능");
        }

        GameRoundResult lastRound = rounds.get(rounds.size() - 1);
        int max = getMax(lastRound);
        return lastRound.carStatus
                .entrySet()
                .stream()
                .filter(stringCounterEntry -> stringCounterEntry.getValue().getCount() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getMax(GameRoundResult lastRound) {
        return lastRound.carStatus
                .values()
                .stream()
                .mapToInt(Counter::getCount)
                .max().orElse(0);
    }

    public static class GameRoundResult {
        private final Map<String, Counter> carStatus = new HashMap<>();

        public Map<String, Counter> getCarStatus() {
            return carStatus;
        }

        public void addResult(String name, Counter status) {
            Objects.requireNonNull(name);
            Objects.requireNonNull(status);
            carStatus.put(name, status);
        }
    }
}
