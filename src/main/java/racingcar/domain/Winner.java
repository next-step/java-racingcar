package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final Records records;

    public Winner(Records lastRoundRecords) {
        this.records = lastRoundRecords;
    }

    public List<String> getWinners() {
        return records.getBestRecord()
                .stream()
                .map(Record::getName)
                .collect(Collectors.toList());
    }
}