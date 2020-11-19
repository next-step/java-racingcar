package racingcar;

import java.util.Map;

public class RaceRecord {
    private final int round;
    private final Map<String, Integer> recordsWithCarName;

    RaceRecord(int round, Map<String, Integer> map) {
        this.round = round;
        this.recordsWithCarName = map;
    }

    public int getRound() {
        return round;
    }

    public Map<String, Integer> getRecordsWithCarName() {
        return recordsWithCarName;
    }

}
