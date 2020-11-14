package racingcar;

import java.util.List;

public class RaceRecord {
    private final int round;
    private final List<Integer> records;

    RaceRecord(int round, List<Integer> records) {
        this.round = round;
        this.records = records;
    }

    public int getRound() {
        return round;
    }

    public List<Integer> getRecords() {
        return records;
    }
}
