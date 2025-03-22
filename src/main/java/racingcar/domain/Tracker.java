package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tracker {

    private final List<Record> records = new ArrayList<>();

    public void saveRecords(Cars cars) {
        if (cars.isEmpty()) {
            throw new IllegalStateException("자동차는 한 대 이상이어야 기록됩니다.");
        }

        cars.saveRecords(records);
    }

    public List<Record> findWinnerRecords() {

        if (records.isEmpty()) {
            throw new IllegalStateException("기록이 있어야 우승자를 찾을 수 있습니다.");
        }

        int maxPosition = findMaxPosition();

        return records.stream()
                .filter(record -> record.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return records.stream()
                .mapToInt(Record::getPosition)
                .max()
                .orElse(0);
    }

    public List<Record> findAllRecords() {
        return records;
    }
}
