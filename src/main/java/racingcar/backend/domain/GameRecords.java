package racingcar.backend.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameRecords {

    private final List<GameRecord> values;

    public GameRecords() {
        this.values = new ArrayList<>();
    }

    public void add(GameRecord gameRecord) {
        values.add(gameRecord);
    }

    public List<GameRecord> getValues() {
        return values;
    }

    public List<String> finalWinner() {
        int maxPosition = getMaxPosition();
        return lastGame().stream()
                .flatMap(e -> e.entrySet().stream())
                .filter(e -> e.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return lastGame().stream()
                .flatMap(e -> e.entrySet().stream())
                .max(Map.Entry.comparingByValue())
                .get().getValue();
    }

    private List<Map<String, Integer>> lastGame() {
        return values.get(values.size() - 1).getValues();
    }
}
