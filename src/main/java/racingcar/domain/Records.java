package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Records {
    private final List<Record> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    public void save(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Record> getBestRecord() {
        int maxPosition = records.stream()
                .mapToInt(Record::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);

        return records.stream()
                .filter(record -> record.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
