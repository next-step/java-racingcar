package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Records {
    List<Record> records = new ArrayList<>();

    public Records() {

    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public List<Record> getRecords() {
        return this.records;
    }

}
