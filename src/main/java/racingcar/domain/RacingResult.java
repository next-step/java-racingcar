package racingcar.domain;

import java.util.List;

public class RacingResult {

    private List<Record> records;

    public RacingResult(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }
}
