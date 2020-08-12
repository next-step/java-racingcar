package racingcar.domain;

import java.util.List;

public class RaceRecords {
    private final List<RaceRecord> raceRecords;

    public RaceRecords(List<RaceRecord> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

}
