package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceRecord {

    private List<Integer> record;

    public RaceRecord() {
        this.record = new ArrayList<>();
    }

    public void add(int move) {
        record.add(move);
    }

    public int getBy(int attemptTime) {
        return record.get(attemptTime);
    }
}
