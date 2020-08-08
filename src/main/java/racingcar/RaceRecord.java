package racingcar;

import java.util.List;

public class RaceRecord {

    private List<Integer> record;

    public RaceRecord(List<Integer> record) {
        this.record = record;
    }

    public int getBy(int attemptTime) {
        return record.get(attemptTime);
    }
}
