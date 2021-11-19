package step4.dto.record;

import step3.Count;

import java.util.List;

public class RecordGroup {

    List<Record> records;

    public RecordGroup(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public Count recoredCount() {
        return new Count(records.size());
    }
}
