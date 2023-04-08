package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Records {

    private List<Record> records;

    public Records(int tryRound) {
        records = new ArrayList<>(tryRound);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}
