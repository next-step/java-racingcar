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

    public List<Record> getWinnersRecords() {
        return recordList
                .stream()
                .filter(record -> record.getLocation() == getMaxLocation())
                .collect(Collectors.toList());
    }

    private Integer getMaxLocation() {
        return recordList
                .stream()
                .mapToInt(Record::getLocation)
                .max()
                .getAsInt();
    }

}
