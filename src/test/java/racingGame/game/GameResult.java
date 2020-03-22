package racingGame.game;

import java.util.List;

public class GameResult {
    private List<CarRecord> records;

    public GameResult(List<CarRecord> records) {
        this.records = records;
    }

    public List<CarRecord> getRecords() {
        return records;
    }
}