package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRecord {
    private final List<Cars> records;

    public RacingRecord(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("1이상 입력해주세요");
        }

        this.records = new ArrayList<>(capacity);
    }

    public void save(Cars cars) {
        this.records.add(cars);
    }

    public List<Cars> getRecords() {
        return Collections.unmodifiableList(this.records);
    }

    public List<Car> winners() {
        Cars last = this.records.get(records.size() - 1);
        return last.winners();
    }
}
