package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final Records record;

    public Winner(List<Records> records) {
        this.record = getLastRound(records);
    }

    private Records getLastRound(List<Records> records) {
        return records.get(records.size() - 1);
    }

    public List<String> getWinners() {
        int maxDistance = record.getRecords().stream().mapToInt(Record::getPosition).max().orElse(0);
        return record.getRecords().stream().filter(record -> record.getPosition() == maxDistance)
                .map(Record::getName)
                .collect(Collectors.toList());
    }
}