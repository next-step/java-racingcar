package racingcar.backend.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameRecords {

    private final List<GameRecord> values;

    public GameRecords() {
        this.values = new ArrayList<>();
    }

    public static GameRecords create() {
        return new GameRecords();
    }

    public void add(GameRecord gameRecord) {
        values.add(gameRecord);
    }

    public List<CarName> finalWinner() {
        return lastGame().entrySet().stream()
                .filter(entry -> entry.getValue().getValue() == getMaxPosition())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return Collections.max(lastGame().values(),
                Comparator.comparingInt(Position::getValue)).getValue();
    }

    private Map<CarName, Position> lastGame() {
        return values.get(values.size() - 1).getValue();
    }

    public List<GameRecord> getValues() {
        return new ArrayList<>(values);
    }
}
