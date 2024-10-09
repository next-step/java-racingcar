package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private final List<Record> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    public void save(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }

}
