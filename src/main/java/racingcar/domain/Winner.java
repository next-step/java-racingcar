package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Record> records;

    public Winner(final List<Record> records) {
        this.records = records;
    }

    public List<String> judgeWinner() {
        final int max = records.stream()
                .mapToInt(Record::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));

        return records.stream()
                .filter(record -> record.getDistance() == max)
                .map(record -> record.getName())
                .collect(Collectors.toList());
    }
}
