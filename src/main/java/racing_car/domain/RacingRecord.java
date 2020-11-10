package racing_car.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRecord {

    private List<LabRecord> labRecordList;

    public RacingRecord(List<LabRecord> labRecordList) {
        this.labRecordList = Collections.unmodifiableList(labRecordList);
    }

    public List<LabRecord> toLabRecordList() {
        return this.labRecordList;
    }

    private List<Record> getFinalLabWinnersRecord() {
        return findFinalLabRecord()
                .findWinnersRecords();
    }

    public List<String> getFinalLabWinnersName() {
        return getFinalLabWinnersRecord()
                .stream()
                .map(Record::getName)
                .collect(Collectors.toList());
    }

    private LabRecord findFinalLabRecord() {
        return labRecordList.get(labRecordList.size() - 1);
    }

}
