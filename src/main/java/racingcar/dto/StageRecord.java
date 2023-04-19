package racingcar.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StageRecord {

    public static final int FIRST_STAGE_INDEX = 1;
    private final int stage;
    private final List<Record> records;

    public StageRecord(int stage, List<Record> records) {
        this.stage = stage + FIRST_STAGE_INDEX;
        this.records = records;
    }

    public List<Record> getRank() {
        return records
                .stream()
                .sorted(Comparator.comparing(Record::getMoveCount).reversed())
                .collect(Collectors.toList());
    }

    public Record highRecord() {
        return this.getRank()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public int getStage() {
        return stage;
    }

    public List<Record> getRecords() {
        return records;
    }
}
