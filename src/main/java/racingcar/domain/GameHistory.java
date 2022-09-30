package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {

    private List<GameRecord> values;

    public GameHistory() {
        this.values = new ArrayList<>();
    }

    public void addResult(GameRecord gameRecord) {
        values.add(gameRecord);
    }

    public List<GameRecord> getValues() {
        return values;
    }
}
