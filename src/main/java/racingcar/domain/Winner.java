package racingcar.domain;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Winner {

    private final Records records;

    public Winner(List<Records> records) {
        this.records = getLastRound(records);
    }

    private Records getLastRound(final List<Records> records) {
        return records.get(records.size() - 1);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();

        return records.getRecords().stream()
                .filter(record -> record.getDistance() == maxDistance)
                .map(Record::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        OptionalInt maxDistance = records.getRecords().stream()
                .mapToInt(Record::getDistance)
                .max();

        return maxDistance.orElse(0);
    }
}
