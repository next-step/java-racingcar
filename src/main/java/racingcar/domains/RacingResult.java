package racingcar.domains;

import java.util.List;

public class RacingResult {

    private final List<Integer> records;

    public RacingResult(List<Integer> records) {
        this.records = records;
    }

    public List<Integer> getRecords() {
        return records;
    }
}
