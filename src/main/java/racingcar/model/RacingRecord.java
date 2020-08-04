package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final List<String> recordList = new ArrayList<>();

    public void record(RacingRound racingRound) {
        recordList.add(racingRound.getRoundRecord());
    }

    public List<String> getAllRecord() {
        return recordList;
    }
}
