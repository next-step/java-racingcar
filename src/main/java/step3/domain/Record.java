package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<Integer> record;

    public Record() {
        this.record = new ArrayList<>();
    }

    public Record(List<Integer> record) {
        this.record = record;
    }

    public void addRecord(int record) {
        System.out.println("record = " + record);
        this.record.add(record);
    }

    public int getLastRecord() {
        if (this.isEmpty()) {
            return 0;
        }
        return record.get(record.size() - 1);
    }

    private boolean isEmpty() {
        return record.size() == 0;
    }

    public List<Integer> getRecord() {
        return record;
    }
}
