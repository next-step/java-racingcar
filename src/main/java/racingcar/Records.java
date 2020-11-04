package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Records {

    private final List<Record> records;

    public Records(int num) {
        this.records = new ArrayList<>(num);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecordList() {
        return records;
    }
}