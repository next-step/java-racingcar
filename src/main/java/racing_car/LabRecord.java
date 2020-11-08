package racing_car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LabRecord {

    private List<Record> recordList;

    public LabRecord(List<Record> recordList) {
        this.recordList = Collections.unmodifiableList(recordList);
    }

    public List<Record> toRecordList() {
        return recordList;
    }

    public List<Record> findWinnersRecords() {
        Record bestRecord = findBestRecord();
        return recordList.stream()
                .filter(record -> record.isSameLocation(bestRecord))
                .collect(Collectors.toList());
    }

    private Record findBestRecord() {
        return recordList.stream()
                .max(Record::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EMPTY_RECORD));
    }

}
