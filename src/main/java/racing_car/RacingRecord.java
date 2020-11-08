package racing_car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRecord {

    private List<LabRecord> labRecordList = new ArrayList<>();

    public void addLabRecord(LabRecord labRecord) {
        this.labRecordList.add(labRecord);
    }

    public List<LabRecord> toLabRecordList() {
        return this.labRecordList;
    }

    private List<Record> getFinalLabWinnersRecord() {
        return getFinalLabRecord()
                .getWinnersRecords();
    }

    public List<String> getFinalLabWinnersName() {
        return getFinalLabWinnersRecord()
                .stream()
                .map(Record::getName)
                .collect(Collectors.toList());
    }

    private LabRecord getFinalLabRecord() {
        return labRecordList.get(labRecordList.size() - 1);
    }

}
