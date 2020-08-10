package racingcar;

import java.util.List;

public class RaceRecord {
    private String name;
    private List<Integer> record;

    public RaceRecord(String name, List<Integer> record) {
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return this.name;
    }

    public int getBy(int attemptTime) {
        return record.get(attemptTime);
    }

}
