package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundRecords {

    private final List<RoundRecord> roundRecords;

    public RoundRecords(int num) {
        this.roundRecords = new ArrayList<>(num);
    }

    public void addRecord(RoundRecord roundRecord) {
        roundRecords.add(roundRecord);
    }

    public List<RoundRecord> getRoundRecordList() {
        return roundRecords;
    }
}