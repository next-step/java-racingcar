package racingcar;

import util.StringUtils;

import java.util.List;

public class RaceRecord {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RACE_TRACK = "-";
    private static final String DELIMITER = " : ";

    private String name;
    private List<Integer> record;

    public RaceRecord(String name, List<Integer> record) {
        this.name = name;
        this.record = record;
    }

    public int getBy(int attemptTime) {
        return record.get(attemptTime);
    }

    public String getResultByAttempt(int attempt) {
        return name + " : " + StringUtils.repeat(RACE_TRACK, getBy(attempt));
    }
}
