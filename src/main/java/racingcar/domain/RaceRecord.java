package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;

public class RaceRecord {
    private String name;
    private List<Boolean> records;

    public RaceRecord(String name, List<Boolean> records) {
        this.name = name;
        this.records = records;
    }

    public String getName() {
        return this.name;
    }

    public int getBy(int attemptTime) {
        return Stream.iterate(0, attempt -> attempt + 1)
                .limit(attemptTime)
                .mapToInt(attempt -> records.get(attempt).compareTo(Boolean.TRUE))
                .sum();
    }

    public int getLastRecord() {
        return records.stream()
                .mapToInt(record -> record.compareTo(Boolean.TRUE))
                .sum();
    }
}
