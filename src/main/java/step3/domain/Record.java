package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<Integer> record;

    public Record() {
        this.record = new ArrayList<>();
    }

    public void addRecord(int record) {
        this.record.add(record);
    }

    public int getLastRecord() {
        if (record.size() == 0) {
            return 0;
        }
        return record.get(record.size() - 1);
    }

    public List<Integer> getRecord() {
        return record;
    }
}
