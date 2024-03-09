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

    public void record(int turn, Car car) {
        this.records[turn].add(new Record(car));
    }

    public List<Record> racingRecord(int turn) {
        return this.records[turn];
    }
}
