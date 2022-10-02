package racingcar.backend.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRecords {

    private List<GameRecord> values;

    public GameRecords() {
        this.values = new ArrayList<>();
    }

    public void addResult(GameRecord gameRecord) {
        values.add(gameRecord);
    }

    public List<GameRecord> getValues() {
        return values;
    }
}
