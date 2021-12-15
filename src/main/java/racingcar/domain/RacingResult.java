package racingcar.domain;

import java.util.List;

public class RacingResult {

    private Records records;

    public RacingResult(Records records) {
        this.records = records;
    }

    public RacingResult(List<Record> records) {
        this(new Records(records));
    }

    public Records getRecords() {
        return records;
    }

    public RacingCars getWinners() {
        Record record = records.getLast();

        return record.calculateLeader();
    }

}
