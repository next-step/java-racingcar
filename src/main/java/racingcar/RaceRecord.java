package racingcar;

import util.StringUtils;

import java.util.List;

public class RaceRecord {
    private static final String RACE_TRACK = "-";
    private static final String DELIMITER = " : ";

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

    public String getResultStringByAttempt(int attempt) {
        return name + DELIMITER + StringUtils.repeat(RACE_TRACK, getBy(attempt));
    }
}
