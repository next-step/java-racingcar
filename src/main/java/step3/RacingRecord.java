package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final List<List<Integer>> racingRecord = new ArrayList<>();

    public void saveOneStepRecord(List<Integer> stepResult) {
        racingRecord.add(stepResult);
    }

    public List<List<Integer>> getRacingRecord() {
        return racingRecord;
    }
}
