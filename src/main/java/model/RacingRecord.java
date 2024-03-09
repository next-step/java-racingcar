package model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final List<Record>[] records;

    public RacingRecord(int turn) {
        this.records = init(turn);
    }

    @SuppressWarnings("unchecked")
    private List<Record>[] init(int turn) {
        List<Record>[] result = new ArrayList[turn + 1];
        for (int i = 1; i <= turn; i++) {
            result[i] = new ArrayList<>();
        }

        return result;
    }

    public void save(int turn, Record record) {
        this.records[turn].add(record);
    }

    public List<Record> racingRecord(int turn) {
        return this.records[turn];
    }
}
