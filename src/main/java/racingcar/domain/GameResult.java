package racingcar.domain;

import java.util.List;

public class GameResult {

    private List<Records> records;
    private Records lastRecords;

    public GameResult(List<Records> records) {
        this.records = records;
        this.lastRecords = records.get(records.size() - 1);
    }

    public List<String> findWinners() {
        return lastRecords.findWinners();
    }

    public List<Records> getRecords() {
        return records;
    }
}
