package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private final List<RaceRecord> raceRecord;

    public RaceResult() {
        this.raceRecord = new ArrayList<>();
    }

    public void record(Cars cars) {
        raceRecord.add(new RaceRecord(cars));
    }

    public List<RaceRecord> getRaceRecord() {
        return raceRecord;
    }

}
