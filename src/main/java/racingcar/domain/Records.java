package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Records {
    List<Record> records = new ArrayList<>();

    public Records() {

    }

    public Records(List<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public Record lastRecord() {
        return this.records.get(records.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Records records1 = (Records) o;
        return Objects.equals(records, records1.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records);
    }
}
