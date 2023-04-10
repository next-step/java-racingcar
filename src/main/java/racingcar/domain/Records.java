package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Records {

    private final List<Record> records;

    public Records() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}
