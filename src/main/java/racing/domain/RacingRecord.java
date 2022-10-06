package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private List<String> racingRecord;

    public RacingRecord() {
        this.racingRecord = new ArrayList<>();
    }

    public List<String> getRacingRecord() {
        return racingRecord;
    }

    public void addAll(RacingRecord records) {
        this.racingRecord.addAll(records.getRacingRecord());
    }

    public void add(String skidMark) {
        racingRecord.add(skidMark);
    }
}
